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
import javax.swing.JOptionPane;
import model.bean.ItemProjeto;
import model.bean.Projeto;

public class ItemProjetoDAO {

    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public List<ItemProjeto> GetAll(int pId, Projeto pProjeto, boolean OnlyLast) {
        List<ItemProjeto> itens = new ArrayList<>();

        try {
            con = DataConnection.getConnection();

            String CmdSelect = "select "
                    + "Id"
                    + ", Projeto"
                    + ", Modulo"
                    + ", Inversor"
                    + ", ValorUnitario"
                    + ", Quantidade "
                    + "from ItemProjeto "
                    + "where "
                    + "Projeto = ? "
                            .concat(
                                    pId > 0
                                            ? " and Id = ? "
                                            : (OnlyLast ? " order by Id desc limit 1 " : " order by Id asc ")
                            );

            stmt = con.prepareStatement(CmdSelect);
            stmt.setInt(1, pProjeto.getId());

            if (pId > 0) {
                stmt.setInt(2, pId);
            }

            rs = stmt.executeQuery();
            while (rs.next()) {
                ItemProjeto ip = new ItemProjeto();
                ip.setId(rs.getInt("Id"));
//                ip.setProjeto(ProjetoCTRL.BuscarPorId(rs.getInt("Projeto")));
                ip.setProjeto(pProjeto);
                if (rs.getInt("Modulo") > 0) {
                    ip.setModulo(ModuloCTRL.BuscaPorId(rs.getInt("Modulo")));
                }
                if (rs.getInt("Inversor") > 0) {
                    ip.setInversor(InversorCTRL.BuscaPorId(rs.getInt("Inversor")));
                }
                ip.setValorUnitario(rs.getDouble("ValorUnitario"));
                ip.setQuantidade(rs.getInt("Quantidade"));
                itens.add(ip);
            }
        } catch (SQLException e) {
            System.out.println("Erro select ItemProjeto:\r\n " + e);
            Logger.getLogger(ItemProjetoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }

        return itens;
    }

    public ItemProjeto Persist(ItemProjeto item) {

        try {
            con = DataConnection.getConnection();

            String CmdSQL = item.IsNew()
                    ? "insert into ItemProjeto set "
                    + "Projeto = ?"
                    + (item.getModulo() != null ? ", Modulo = ?" : "")
                    + (item.getInversor() != null ? ", Inversor = ?" : "")
                    + ", ValorUnitario = ?"
                    + ", Quantidade = ?"
                    : "update ItemProjeto set "
                    + "Projeto = ?"
                    + (item.getModulo() != null ? ", Modulo = ?" : "")
                    + (item.getInversor() != null ? ", Inversor = ?" : "")
                    + ", ValorUnitario = ?"
                    + ", Quantidade = ? "
                    + "where Id = ?";

            stmt = con.prepareStatement(CmdSQL);
            int ii = 1;
            stmt.setInt(ii++, item.getProjeto().getId());
            if (item.getModulo() != null) {
                stmt.setInt(ii++, item.getModulo().getId());
            }
            if (item.getInversor() != null) {
                stmt.setInt(ii++, item.getInversor().getId());
            }
            stmt.setDouble(ii++, item.getValorUnitario());
            stmt.setInt(ii++, item.getQuantidade());
            if (!item.IsNew()) {
                stmt.setInt(ii++, item.getId());
            }

            stmt.executeUpdate();

//            Utilitarios.MsgSucesso();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, (item.IsNew() ? "INCLUINDO " : "ATUALIZANDO ") + ItemProjeto.class.getSimpleName() + "\r\n " + ex, "<<< Comportamento não previsto >>>", 2);
            Logger.getLogger(ItemProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }

        return item.IsNew() ? this.GetAll(0, item.getProjeto(), true).get(0) : item;
    }
}
