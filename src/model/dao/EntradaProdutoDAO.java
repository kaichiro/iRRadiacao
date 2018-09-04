package model.dao;

import connection.DataConnection;
import controller.FornecedorCTRL;
import controller.ItemEntradaCTRL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.EntradaProduto;
import model.bean.ItemEntrada;
import utils.Utilitarios;

public class EntradaProdutoDAO {

    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private List<EntradaProduto> GetAll(int Limite, int Id, String FornecedorNome, boolean ApenasUltimoRegistro) {
        List<EntradaProduto> EntradasProdutos = new ArrayList<>();

        try {
            con = DataConnection.getConnection();
            String SelectCMD = "select ep.Id\n"
                    + ", ep.Data\n"
                    + ", ep.Fornecedor\n"
                    + ", coalesce(ep.Descontos,0) Descontos\n"
                    + ", coalesce((select sum(ie.Quantidade * ie.ValorUnitario) from ItemEntrada ie where ie.EntradaProduto = ep.Id and (ie.Modulo is not null or ie.Inversor is not null)),0) ValorProdutos_\n"
                    + ", coalesce((select sum(ie.Quantidade * ie.ValorUnitario) from ItemEntrada ie where ie.EntradaProduto = ep.Id and (ie.Modulo is not null or ie.Inversor is not null)),0) - coalesce(ep.Descontos,0) ValorLiquido_\n"
                    + "from EntradaProduto ep\n";
            if (Id > 0) {
                SelectCMD += " where ep.Id = ? ";
                stmt = con.prepareStatement(SelectCMD);
                stmt.setInt(1, Id);
            } else if (FornecedorNome.length() > 0) {
                SelectCMD += " inner join Fornecedor frn on ep.Fornecedor = frn.Id\n"
                        + "where frn.NomeFantasia like ? or frn.RazaoSocial like ? or frn.CNPJ = ? ";
                stmt = con.prepareStatement(SelectCMD);
                stmt.setString(1, "%" + FornecedorNome + "%");
                stmt.setString(2, "%" + FornecedorNome + "%");
                stmt.setString(3, "%" + FornecedorNome + "%");
            } else if (ApenasUltimoRegistro) {
                SelectCMD += " order by Id desc ";
                stmt = con.prepareStatement(SelectCMD);
            } else {
                stmt = con.prepareStatement(SelectCMD);
            }
            SelectCMD += Limite > 0 ? " limit " + Limite : "";
            rs = stmt.executeQuery();
            while (rs.next()) {
                EntradaProduto ep = new EntradaProduto();
                ep.setData(rs.getDate("Data"));
                ep.setDescontos(rs.getDouble("Descontos"));
                ep.setFornecedor(FornecedorCTRL.BuscarPorId(rs.getInt("Fornecedor")));
                ep.setId(rs.getInt("Id"));
                ep.setValorLiquido_(rs.getDouble("ValorLiquido_"));
                ep.setValorProdutos_(rs.getDouble("ValorProdutos_"));

                List<ItemEntrada> itens = new ArrayList<>();
                ItemEntradaCTRL.BuscarPorEntrada(ep).forEach((ItemEntrada ie) -> {
                    ie.setEntradaProduto(ep);
                    itens.add(ie);
                });
                ep.setItens(itens);

                EntradasProdutos.add(ep);
            }
        } catch (SQLException e) {
            Utilitarios.MsgExcecao("Erro ao tentar buscar Entrada de Produtos: " + e);
            Logger.getLogger(EntradaProduto.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }

        return EntradasProdutos;
    }

    public EntradaProduto GetById(int id) {
        return this.GetAll(0, id, "", false).get(0);
    }

    public List<EntradaProduto> GetByFornecedor(String Nome, int Limite) {
        return this.GetAll(Limite, 0, Nome, false);
    }

    public EntradaProduto GetLastRecord() {
        return this.GetAll(0, 0, "", true).get(0);
    }

    public EntradaProduto Persists(EntradaProduto ep) {
        EntradaProduto retornoEP = new EntradaProduto();

        try {
            con = DataConnection.getConnection();

            if (ep.IsNew()) {
                stmt = con.prepareStatement(
                        "insert into EntradaProduto\n"
                        + "set Fornecedor = ?\n"
                        + ", Descontos = ?"
                );
                stmt.setInt(1, ep.getFornecedor().getId());
                stmt.setDouble(2, ep.getDescontos());
            } else {
                stmt = con.prepareStatement(
                        "update EntradaProduto\n"
                        + "set Fornecedor = ?\n"
                        + ", Descontos = ?\n"
                        + "where Id = ?"
                );
                stmt.setInt(1, ep.getFornecedor().getId());
                stmt.setDouble(2, ep.getDescontos());
                stmt.setInt(3, ep.getId());
            }

            stmt.executeUpdate();

            List<ItemEntrada> ItensAindaNaoPersistidos = ep.getItens();
            List<ItemEntrada> ItensPersistidos = new ArrayList<>();

            retornoEP = ep.IsNew() ? this.GetLastRecord() : ep;

            if (ItensAindaNaoPersistidos != null) {
                for (ItemEntrada item : ItensAindaNaoPersistidos) {
                    item.setEntradaProduto(retornoEP);
                    ItensPersistidos.add(ItemEntradaCTRL.Gravar(item));
                }
                retornoEP.setItens(ItensPersistidos);
            }
//            // guarda itens em uma variável antes de persistir o cabecalho 
//            List<ItemEntrada> itens = ep.getItens();
//
//            // persiti o cabecalho 
//            retornoEP = ep.IsNew() ? this.GetLastRecord() : ep;
//            // laço para atribuir a cada item ao cabealho (seja novo/incluir o existente/atualizar) 
//            for (ItemEntrada item : itens) {
//                item.setEntradaProduto(retornoEP);
//            }
//            // set coleção de itens ao cabecalho 
//            retornoEP.setItens(itens);
//
//            // nova coleção de itens 
//            List<ItemEntrada> ItensPersistidos = new ArrayList<>();
//            // laço de itens ainda não persistidos 
//            for (ItemEntrada iten : retornoEP.getItens()) {
//                // persiste itens pertencentes ao cabecalho já persistido 
//                ItemEntrada ie = ItemEntradaCTRL.Gravar(iten);
//                // set cabecalho ao itens 
//                ie.setEntradaProduto(retornoEP);
//            }
//            // seta coleção de itens já persistidos ao cabecalho persistido 
//            retornoEP.setItens(ItensPersistidos);
            Utilitarios.MsgSucesso();
        } catch (SQLException e) {
            Utilitarios.MsgExcecao("Erro ao tentar Persistir (" + (ep.IsNew() ? "insert" : "update") + ") EntradaProduto: " + e);
            Logger.getLogger(EntradaProduto.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }

//        return ep.IsNew() ? this.GetLastRecord() : ep;
        return this.GetById(retornoEP.getId());
    }
}
