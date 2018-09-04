package model.dao;

import connection.DataConnection;
import controller.InversorCTRL;
import controller.ModuloCTRL;
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

public class ItemEntradaDAO {

    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private List<ItemEntrada> GetAll(EntradaProduto ep, boolean GetLastRecord_ByEntrada) {
        List<ItemEntrada> itens = new ArrayList<>();
        try {
            con = DataConnection.getConnection();

            String SelectCMD = "select Id\n"
                    + ", Inversor\n"
                    + ", Modulo\n"
                    + ", EntradaProduto\n"
                    + ", Quantidade\n"
                    + ", ValorUnitario\n"
                    + "from ItemEntrada\n"
                    + "where EntradaProduto = ?";
            SelectCMD += GetLastRecord_ByEntrada ? " order by Id desc " : "";
            stmt = con.prepareStatement(SelectCMD);
            stmt.setInt(1, ep.getId());
            rs = stmt.executeQuery();

            while (rs.next()) {
                ItemEntrada ie = new ItemEntrada();
                ie.setEntradaProduto(ep);
                ie.setId(rs.getInt("Id"));
                if (rs.getInt("Inversor") > 0) {
                    ie.setInversor(InversorCTRL.BuscaPorId(rs.getInt("Inversor")));
                }
                if (rs.getInt("Modulo") > 0) {
                    ie.setModulo(ModuloCTRL.BuscaPorId(rs.getInt("Modulo")));
                }
                ie.setQuantidade(rs.getInt("Quantidade"));
                ie.setValorUnitario(rs.getDouble("ValorUnitario"));
                ie.setValorTotal_(ie.getQuantidade() * ie.getValorUnitario());

                itens.add(ie);
            }

        } catch (SQLException e) {
            Utilitarios.MsgExcecao("Erro ao tentar buscar Itens de Entrada de Produtos: " + e);
            Logger.getLogger(ItemEntrada.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }

        return itens;
    }

    public List<ItemEntrada> GetByEntrada(EntradaProduto ep) {
        return this.GetAll(ep, false);
    }

    private ItemEntrada GetLastRecord_ByEntrada(EntradaProduto ep) {
        return this.GetAll(ep, true).get(0);
    }

    public ItemEntrada Persists(ItemEntrada ie) {
        try {
            con = DataConnection.getConnection();
            String CmdSQL = ie.IsNew()
                    ? "insert into ItemEntrada\n"
                    + "set EntradaProduto = ?\n"
                    + (ie.getModulo() != null ? ", Modulo = ?\n" : "")
                    + (ie.getInversor() != null ? ", Inversor = ?\n" : "")
                    + ", Quantidade = ?\n"
                    + ", ValorUnitario = ?"
                    : "update ItemEntrada\n"
                    + "set EntradaProduto = ?\n"
                    + (ie.getModulo() != null ? ", Modulo = ?\n" : "")
                    + (ie.getInversor() != null ? ", Inversor = ?\n" : "")
                    + ", Quantidade = ?\n"
                    + ", ValorUnitario = ?\n"
                    + "where Id = ?";
            stmt = con.prepareStatement(CmdSQL);
            int ii = 1;
            stmt.setInt(ii++, ie.getEntradaProduto().getId());
            if (ie.getModulo() != null) {
                stmt.setInt(ii++, ie.getModulo().getId());
            }
            if (ie.getInversor() != null) {
                stmt.setInt(ii++, ie.getInversor().getId());
            }
            stmt.setInt(ii++, ie.getQuantidade());
            stmt.setDouble(ii++, ie.getValorUnitario());
            if (!ie.IsNew()) {
                stmt.setInt(ii++, ie.getId());
            }
            stmt.executeUpdate();
//            Utilitarios.MsgSucesso();
        } catch (SQLException e) {
            Utilitarios.MsgExcecao("Erro ao tentar Persistir(" + (ie.IsNew() ? "Insert" : "Update") + ") Itens de Entrada de Produtos: " + e);
            Logger.getLogger(ItemEntrada.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }

        return ie.IsNew() ? this.GetLastRecord_ByEntrada(ie.getEntradaProduto()) : ie;
    }
}
