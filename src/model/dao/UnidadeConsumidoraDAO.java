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
import model.bean.Endereco;
import model.bean.Projeto;
import model.bean.UnidadeConsumidora;
import utils.Enumeradors;

public class UnidadeConsumidoraDAO {

    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public List<UnidadeConsumidora> GetAll(int pLimite, boolean OnlyLast, int pIdUnidConsumid, Endereco pEndereco) {
        List<UnidadeConsumidora> UCs = new ArrayList<>();

        try {
            con = DataConnection.getConnection();

            String CmdSelect = "select Id, Numero, TipoDeLigacao, NumeroMedidor, Endereco from UnidadeConsumidora ";
            String Limite = pLimite > 0 ? " limit " + pLimite : "";

            if (OnlyLast) {
                stmt = con.prepareStatement(CmdSelect.concat(" order by Id desc limit 1 "));
            } else if (pIdUnidConsumid > 0) {
                stmt = con.prepareStatement(CmdSelect.concat(" where Id = ? "));
                stmt.setInt(1, pIdUnidConsumid);
            } else if (pEndereco != null) {
                stmt = con.prepareStatement(CmdSelect.concat(" where Endereco = ? ").concat(Limite));
                stmt.setInt(1, pEndereco.getId());
            } else {
                stmt = con.prepareStatement(CmdSelect.concat(Limite));
            }
            rs = stmt.executeQuery();

            while (rs.next()) {
                UnidadeConsumidora uc = new UnidadeConsumidora();
                uc.setId(rs.getInt("Id"));
                uc.setNumero(rs.getString("Numero"));
                uc.setNumeroMedidor(rs.getString("NumeroMedidor"));
                uc.setTipoDeLigacao(Enumeradors.TipoSaidaAC.valueOf(rs.getString("TipoDeLigacao")));
                UCs.add(uc);
            }
        } catch (SQLException e) {
            System.out.println("Erro select UnidadeConsumidora:\r\n " + e);
            Logger.getLogger(UnidadeConsumidoraDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }

        return UCs;
    }

    public UnidadeConsumidora GetById(int id) {
        return this.GetAll(0, false, id, null).get(0);
    }

    public List<UnidadeConsumidora> GetByEndereco(int Limite, Endereco pEndereco) {
        return this.GetAll(Limite, false, 0, pEndereco);
    }

    public UnidadeConsumidora Persist(UnidadeConsumidora uc) {
        try {
            con = DataConnection.getConnection();

            String CmdSQL = uc.IsNew()
                    ? "insert into UnidadeConsumidora set Numero = ?, TipoDeLigacao = ?, NumeroMedidor = ?, Endereco  = ? "
                    : "update UnidadeConsumidora set Numero = ?, TipoDeLigacao = ?, NumeroMedidor = ?, Endereco = ? where Id = ?";

            stmt = con.prepareStatement(CmdSQL);
            int ii = 1;
            stmt.setString(ii++, uc.getNumero());
            stmt.setString(ii++, uc.getTipoDeLigacao().toString());
            stmt.setString(ii++, uc.getNumeroMedidor());
            stmt.setInt(ii++, uc.getEndereco().getId());
            if (!uc.IsNew()) {
                stmt.setInt(ii++, uc.getId());
            }

            stmt.executeUpdate();

//            uc.getConsumosEnergeticos().forEach((ConsumoEnergetico ce) -> {
//                ConsumoEnergeticoCTRL.Gravar(ce);
//            });

//            Utilitarios.MsgSucesso();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, (uc.IsNew() ? "INCLUINDO " : "ATUALIZANDO ") + UnidadeConsumidora.class.getSimpleName() + "\r\n " + ex, "<<< Comportamento não previsto >>>", 2);
            Logger.getLogger(UnidadeConsumidoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }
        return uc.IsNew() ? this.GetAll(0, true, 0, null).get(0) : uc;

    }
}
