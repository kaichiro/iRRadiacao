package model.dao;

import connection.DataConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Contato;
import utils.Utilitarios;

public class ContatoDAO {

    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private List<Contato> GetAll(Cliente cli, int IdContato, boolean OnlyLastRecord) {
        List<Contato> contatos = new ArrayList<>();

        try {
            con = DataConnection.getConnection();
            String CmdSelect = "select Id, Descricao, Cliente from Contato ";
            String UltimoRegistro = OnlyLastRecord ? " order by Id desc limit 1 " : "";
            if (!cli.IsNew() && IdContato > 0) {
                stmt = con.prepareStatement(CmdSelect.concat(" where Cliente = ? and Id = ? "));
                stmt.setInt(1, cli.getId());
                stmt.setInt(2, IdContato);
            } else {
                stmt = con.prepareStatement(CmdSelect.concat(" where Cliente = ? ").concat(UltimoRegistro));
                stmt.setInt(1, cli.getId());
            }
            rs = stmt.executeQuery();
            while(rs.next()){
                contatos.add(new Contato(rs.getInt("Id"), rs.getString("Descricao"), cli));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Endereço: " + e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }

//        if (contatos.isEmpty()) {
//            contatos.add(new Contato());
//        }

        return contatos;
    }

    public List<Contato> GetByCliente(Cliente cli) {
        return this.GetAll(cli, 0, false);
    }

    public Contato GetById(Cliente cli, int pId) {
        return this.GetAll(cli, pId, false).get(0);
    }

    public void Delete(Contato e) {
        Utilitarios.ExcluirObjetos(e.getId(), Contato.class);
    }

    public Contato Persist(Contato contato) {
        try {
            con = DataConnection.getConnection();

            String CmdSQL
                    = contato.IsNew()
                    ? "insert into Contato set Descricao = ?, Cliente = ?;"
                    : "update Contato set Descricao = ?, Cliente = ? where Id = ?;";

            stmt = con.prepareStatement(CmdSQL);
            int ii = 1;
            stmt.setString(ii++, contato.getDescricao());
            stmt.setInt(ii++, contato.getCliente().getId());
            if (!contato.IsNew()) {
                stmt.setInt(ii++, contato.getId());
            }
            stmt.executeUpdate();
//            Utilitarios.MsgSucesso();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, (contato.IsNew() ? "INCLUINDO " : "ATUALIZANDO ") + Contato.class.getSimpleName() + "\r\n " + ex, "<<< Comportamento não previsto >>>", 2);
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return contato.IsNew() ? this.GetAll(contato.getCliente(), 0, true).get(0) : contato;
    }

}
