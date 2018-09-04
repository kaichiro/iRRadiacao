package model.dao;

import connection.DataConnection;
import controller.ItemProjetoCTRL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.ItemProjeto;
import model.bean.Projeto;
import model.bean.Status;
import utils.Utilitarios;

public class ProjetoDAO {

    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public List<Projeto> GetAll(int pLimite, boolean OnlyLast, int pIdProjeto, String pCliente) {

        List<Projeto> projetos = new ArrayList<>();

        try {
            con = DataConnection.getConnection();

            String CmdSelect = "select \n"
                    + "prj.Id\n"
                    + ", prj.DataCadastro\n"
                    + ", prj.DataUltimaAlteracao\n"
                    + ", prj.Cliente\n"
                    + ", prj.Status\n"
                    + ", prj.Desconto\n"
                    + ", prj.Acrescimo\n"
                    + ", prj.PrevisaoEntrega\n"
                    + ", prj.Conclusao \n"
                    + ", clnt.Id as IdCliente\n"
                    + ", clnt.RazaoSocial_Nome as ClienteNome\n"
                    + ", clnt.CNPJ_CPF\n"
                    + ", clnt.NomeFantasia_Apelido\n"
                    + ", sts.Id as IdStatus\n"
                    + ", sts.Descricao as StatusDescricao\n"
                    + "from Projeto prj \n"
                    + "left join Cliente clnt on prj.Cliente = clnt.Id \n"
                    + "left join Status sts on prj.Status = sts.Id ";
            String Limite = pLimite > 0 ? " limit " + pLimite : "";

            if (OnlyLast) {
                stmt = con.prepareStatement(CmdSelect.concat(" order by Id desc limit 1 "));
            } else if (pIdProjeto > 0) {
                stmt = con.prepareStatement(CmdSelect.concat(" where prj.Id = ? ").concat(Limite));
                stmt.setInt(1, pIdProjeto);
            } else if (pCliente != null) {
                stmt = con.prepareStatement(CmdSelect.concat(" where clnt.NomeFantasia_Apelido like ? or clnt.RazaoSocial_Nome like ? ").concat(Limite));
                stmt.setString(1, ("%").concat(pCliente).concat("%"));
                stmt.setString(2, ("%").concat(pCliente).concat("%"));
            } else {
                stmt = con.prepareStatement(CmdSelect.concat(Limite));
            }

            rs = stmt.executeQuery();

            while (rs.next()) {
                Projeto projeto = new Projeto();
                projeto.setAcrescimo(rs.getDouble("Acrescimo") + 0);
                projeto.setConclusao(rs.getDate("Conclusao"));
                projeto.setDataCadastro(rs.getDate("DataCadastro"));
                projeto.setDataUltimaAlteracao(rs.getDate("DataUltimaAlteracao"));
                projeto.setDesconto(rs.getDouble("Desconto") + 0);
                projeto.setId(rs.getInt("Id"));
                projeto.setPrevisaoEntrega(rs.getDate("PrevisaoEntrega"));
//                projeto.setItens(ItemProjetoCTRL.BuscarPorProjeto(projeto));

                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("IdCliente"));
                cliente.setRazaoSocial_Nome(rs.getString("ClienteNome"));
                cliente.setCNPJ_CPF(rs.getString("CNPJ_CPF"));
                cliente.setNomeFantasia_Apelido(rs.getString("NomeFantasia_Apelido"));
                projeto.setCliente(cliente);

                projeto.setStatus(new Status(rs.getInt("IdStatus"), rs.getString("StatusDescricao")));

                /* set itens deste projeto */
                List<ItemProjeto> itens = new ArrayList<>();
                ItemProjetoCTRL.BuscarPorProjeto(projeto).forEach((ItemProjeto ip) -> {
                    ip.setProjeto(projeto);
                    itens.add(ip);
                });
                projeto.setItens(itens);

                double TotalProdutos = 0;
                for (ItemProjeto ip : projeto.getItens()) {
                    TotalProdutos += ip.getQuantidade() * ip.getValorUnitario();
                }
                projeto.setTotalProdutos(TotalProdutos);
                projeto.setTotalLiquido(projeto.getTotalProdutos() + projeto.getAcrescimo() - projeto.getDesconto());
                projeto.setTotalProdutos(0);

                projetos.add(projeto);
            }
        } catch (SQLException e) {
            System.out.println("Erro select Projeto:\r\n " + e);
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }

        return projetos;
    }

    public Projeto GetById(int pId) {
        return this.GetAll(0, false, pId, null).get(0);
    }

    public List<Projeto> GetByCliente(int Limite, String pCliente) {
        return this.GetAll(Limite, false, 0, pCliente);
    }

    public Projeto Persist(Projeto pPrj) {
        Projeto projetoPersistido = new Projeto();

        try {
            con = DataConnection.getConnection();
            String CmdSQL = pPrj.IsNew()
                    ? "insert into Projeto set "
                    + "Cliente = ? "
                    + ",Status = ? "
                    + ",Desconto = ? "
                    + ",Acrescimo = ? "
                    + (pPrj.getPrevisaoEntrega() != null ? ",PrevisaoEntrega = ? " : "")
                    + (pPrj.getConclusao() != null ? ",Conclusao = ?" : "")
                    : "update Projeto set "
                    + "Cliente = ? "
                    + ",Status = ? "
                    + ",Desconto = ? "
                    + ",Acrescimo = ? "
                    + (pPrj.getPrevisaoEntrega() != null ? ",PrevisaoEntrega = ? " : "")
                    + (pPrj.getConclusao() != null ? ",Conclusao = ?" : "")
                    + "where Id = ?";
            stmt = con.prepareStatement(CmdSQL);
            int ii = 1;
            stmt.setInt(ii++, pPrj.getCliente().getId());
            stmt.setInt(ii++, pPrj.getStatus().getId());
            stmt.setDouble(ii++, pPrj.getDesconto());
            stmt.setDouble(ii++, pPrj.getAcrescimo());
            if (pPrj.getPrevisaoEntrega() != null) {
                stmt.setDate(ii++, (Date) pPrj.getPrevisaoEntrega());
            }
            if (pPrj.getConclusao() != null) {
                stmt.setDate(ii++, (Date) pPrj.getConclusao());
            }
            if (!pPrj.IsNew()) {
                stmt.setInt(ii++, pPrj.getId());
            }

            stmt.executeUpdate();

            List<ItemProjeto> ItensAindaNaoPersistidos = pPrj.getItens();
            List<ItemProjeto> ItensPersistidos = new ArrayList<>();

            projetoPersistido = pPrj.IsNew() ? this.GetAll(1, true, 0, "").get(0) : pPrj;

            if (ItensAindaNaoPersistidos != null) {
                for (ItemProjeto item : ItensAindaNaoPersistidos) {
                    item.setProjeto(projetoPersistido);
                    ItensPersistidos.add(ItemProjetoCTRL.Grava(item));
                }
                projetoPersistido.setItens(ItensPersistidos);
            }

//            if (pPrj.IsNew()) {
//                projetoPersistido = this.GetAll(0, true, 0, null).get(0);
//                projetoPersistido.setItens(pPrj.getItens());
//                projetoPersistido.setUnidadesConsumidoras(pPrj.getUnidadesConsumidoras());
//            } else {
//                projetoPersistido = pPrj;
//            }
//            ClienteCTRL.Gravar(projetoPersistido.getCliente(), con);
//            if (projetoPersistido.getItens() != null) {
//                for (ItemProjeto ip : projetoPersistido.getItens()) {
//                    System.out.println("salvando item");
//                    ip.setProjeto(projetoPersistido);
//                    ItemProjetoCTRL.Grava(ip);
//                }
//            }
//            if ((projetoPersistido.getUnidadesConsumidoras() != null)) {
//                projetoPersistido.getUnidadesConsumidoras().forEach((UnidadeConsumidora uc) -> {
//                    UnidadeConsumidoraCTRL.Gravar(uc);
//                    )}
//            }
            Utilitarios.MsgSucesso();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, (pPrj.IsNew() ? "INCLUINDO " : "ATUALIZANDO ") + Projeto.class.getSimpleName() + "\r\n " + ex, "<<< Comportamento não previsto >>>", 2);
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }

//        return projetoPersistido;
        return this.GetById(projetoPersistido.getId());
    }

}
