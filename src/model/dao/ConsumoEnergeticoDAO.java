package model.dao;

import connection.DataConnection;
import controller.UnidadeConsumidoraCTRL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.ConsumoEnergetico;
import model.bean.UnidadeConsumidora;
import utils.Enumeradors;
import utils.Utilitarios;

public class ConsumoEnergeticoDAO {

    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public List<ConsumoEnergetico> GetAll(int pIdCE, UnidadeConsumidora pUC, boolean OnlyLast) {
        List<ConsumoEnergetico> ConsumosEnergeticos = new ArrayList<>();

        try {
            con = DataConnection.getConnection();

            String CmdSelect = "select Id, MesReferencia, AnoReferencia, Consumo, UnidadeConsumidora, Grupo, ValorFatura, TipoLigacao from ConsumoEnergetico where 1 = 1 ";

            if (OnlyLast) {
                stmt = con.prepareStatement(CmdSelect.concat(" order by Id desc limit 1 "));
            } else {
                stmt = con.prepareStatement(
                        CmdSelect
                                .concat(pIdCE > 0 ? " and Id = ? " : "")
                                .concat(pUC != null ? " and UnidadeConsumidora = ? order by AnoReferencia, MesReferencia " : "")
                );
            }

            int ii = 1;
            if (pIdCE > 0) {
                stmt.setInt(ii++, pIdCE);
            }

            if (pUC != null) {
                stmt.setInt(ii++, pUC.getId());
            }

            rs = stmt.executeQuery();
            while (rs.next()) {
                ConsumoEnergetico ce = new ConsumoEnergetico();
                ce.setConsumo(rs.getDouble("Consumo"));
                ce.setGrupo(rs.getString("Grupo"));
                ce.setId(rs.getInt("Id"));
                ce.setMesReferencia(rs.getInt("MesReferencia"));
                ce.setAnoReferencia(rs.getInt("AnoReferencia"));
                ce.setTipoLigacao(Enumeradors.TipoSaidaAC.valueOf(rs.getString("TipoLigacao")));
                ce.setUnidadeConsumidora(UnidadeConsumidoraCTRL.BuscarPorId(rs.getInt("UnidadeConsumidora")));
                ce.setValorFatura(rs.getDouble("ValorFatura"));
                ConsumosEnergeticos.add(ce);
            }
        } catch (SQLException e) {
            System.out.println("Erro select ConsumoEnergetico:\r\n " + e);
            Logger.getLogger(ConsumoEnergeticoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }

        return ConsumosEnergeticos;
    }

    public ConsumoEnergetico Persit(ConsumoEnergetico pCE) {
        try {
            con = DataConnection.getConnection();

            String CmdSQL = pCE.IsNew()
                    ? "\r\ninsert into ConsumoEnergetico set "
                    + "\r\nUnidadeConsumidora = ?"
                    + "\r\n, MesReferencia = ?"
                    + "\r\n, AnoReferencia = ?"
                    + "\r\n, Consumo = ?"
                    + "\r\n, Grupo = ?"
                    + "\r\n, ValorFatura = ?"
                    + "\r\n, TipoLigacao  = ?"
                    : "\r\nupdate ConsumoEnergetico set "
                    + "\r\nUnidadeConsumidora = ?"
                    + "\r\n, MesReferencia = ?"
                    + "\r\n, AnoReferencia = ?"
                    + "\r\n, Consumo = ?"
                    + "\r\n, Grupo = ?"
                    + "\r\n, ValorFatura = ?"
                    + "\r\n, TipoLigacao  = ? "
                    + "\r\nwhere Id = ?";

            stmt = con.prepareStatement(CmdSQL);
            int ii = 1;
            stmt.setInt(ii++, pCE.getUnidadeConsumidora().getId());
            stmt.setInt(ii++, pCE.getMesReferencia());
            stmt.setInt(ii++, pCE.getAnoReferencia());
            stmt.setDouble(ii++, pCE.getConsumo());
            stmt.setString(ii++, pCE.getGrupo());
            stmt.setDouble(ii++, pCE.getValorFatura());
            stmt.setString(ii++, pCE.getTipoLigacao().toString());
            if (!pCE.IsNew()) {
                stmt.setInt(ii++, pCE.getId());
            }

//            System.out.println(CmdSQL + "\r\n" + pCE.toString());
            stmt.executeUpdate();

//            Utilitarios.MsgSucesso();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, (pCE.IsNew() ? "INCLUINDO " : "ATUALIZANDO ") + ConsumoEnergetico.class.getSimpleName() + "\r\n " + ex, "<<< Comportamento não previsto >>>", 2);
            Logger.getLogger(ConsumoEnergeticoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }
        return pCE.IsNew() ? this.GetAll(0, null, true).get(0) : pCE;
    }
}
