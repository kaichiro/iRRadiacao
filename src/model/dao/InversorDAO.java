package model.dao;

import connection.DataConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Inversor;
import controller.StatusCTRL;
import utils.Utilitarios;

public class InversorDAO {

    private int id = 0;
    private String Modelo = "";
    private final String InsertCMD = "insert into Inversor "
            + "set Status = ?,"
            + "Modelo = ?,"
            + "PotenciaWCA = ?,"
            + "PotenciaMaxWCC = ?,"
            + "IccMaxEntradaA = ?,"
            + "UccMaxEntradaA = ?,"
            + "RendimentoNacional = ?,"
            + "RendimentoMaximo = ?,"
            + "ValorVenda = ?,"
            + "TipoSaidaAC = ?;";
    private String SelectCMD = "SELECT Id,\n"
            + "    Status,\n"
            + "    Modelo,\n"
            + "    PotenciaWCA,\n"
            + "    PotenciaMaxWCC,\n"
            + "    IccMaxEntradaA,\n"
            + "    UccMaxEntradaA,\n"
            + "    RendimentoNacional,\n"
            + "    RendimentoMaximo,\n"
            + "    ValorVenda,\n"
            + "    TipoSaidaAC,"
            + " Saldo \n"
            + "FROM Inversor\n ";
    private boolean onlyLastRecord = false;
    private final String UpdateCMD = "UPDATE Inversor\n"
            + "SET\n"
            + "Status = ?,\n"
            + "Modelo = ?,\n"
            + "PotenciaWCA = ?,\n"
            + "PotenciaMaxWCC = ?,\n"
            + "IccMaxEntradaA = ?,\n"
            + "UccMaxEntradaA = ?,\n"
            + "RendimentoNacional = ?,\n"
            + "RendimentoMaximo = ?,\n"
            + "ValorVenda = ?,\n"
            + "TipoSaidaAC = ?\n"
            + "WHERE Id = ?;";
    private int qtdeRegistros;

    private int getQtdeRegistros() {
        return qtdeRegistros;
    }

    private void setQtdeRegistros(int qtdeRegistros) {
        this.qtdeRegistros = qtdeRegistros;
    }

    private int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    private String getModelo() {
        return Modelo;
    }

    private void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    private boolean isOnlyLastRecord() {
        return onlyLastRecord;
    }

    private void setOnlyLastRecord(boolean onlyLastRecord) {
        this.onlyLastRecord = onlyLastRecord;
    }

    public Inversor Insert(Inversor inversor) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DataConnection.getConnection();
            stmt = con.prepareStatement(InsertCMD);
            int i = 1;
            stmt.setInt(i++, inversor.getStatus().getId());
            stmt.setString(i++, inversor.getModelo());
            stmt.setInt(i++, inversor.getPotenciaWCA());
            stmt.setInt(i++, inversor.getPotenciaMaxWCC());
            stmt.setDouble(i++, inversor.getIccMaxEntradaA());
            stmt.setDouble(i++, inversor.getUccMaxEntradaA());
            stmt.setDouble(i++, inversor.getRendimentoNacional());
            stmt.setDouble(i++, inversor.getRendimentoMaximo());
            stmt.setDouble(i++, inversor.getValorVenda());
            stmt.setString(i++, inversor.getTipoSaidaAC().toString());
            stmt.execute();
            Utilitarios.MsgSucesso();
        } catch (SQLException e) {
            Utilitarios.MsgExcecao("Erro ao incluir Inversor: " + e.getMessage());
        } finally {
            DataConnection.closeConnection(con, stmt);
        }
        this.setOnlyLastRecord(true);
        return this.GetAll(this.getQtdeRegistros()).get(0);
    }

    public List<Inversor> GetAll(int pMaxResultRecord) {
        this.setQtdeRegistros(pMaxResultRecord);
        String Limite = this.getQtdeRegistros() > 0 ? (" limit " + pMaxResultRecord) : "";

        List<Inversor> inversores = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = DataConnection.getConnection();
            if (this.getId() > 0) {
                SelectCMD += " where Id = ?" + Limite;
                stmt = con.prepareStatement(SelectCMD);
                stmt.setInt(1, this.getId());
            } else if (this.getModelo().trim().length() > 0) {
                SelectCMD += " where Modelo like ?" + Limite;
                stmt = con.prepareStatement(SelectCMD);
                stmt.setString(1, this.getModelo().concat("%"));
            } else if (this.isOnlyLastRecord()) {
                SelectCMD += " order by Id desc limit 1" + Limite;
                stmt = con.prepareStatement(SelectCMD);
            } else {
                stmt = con.prepareStatement(SelectCMD + Limite);
            }

            rs = stmt.executeQuery();
//            System.out.println(rs.getStatement().toString());
            while (rs.next()) {
                inversores.add(
                        new Inversor(
                                rs.getInt("Id"),
                                StatusCTRL.BuscaPorId(rs.getInt("Status")),
                                rs.getString("Modelo"),
                                rs.getInt("PotenciaWCA"),
                                rs.getInt("PotenciaMaxWCC"),
                                rs.getDouble("IccMaxEntradaA"),
                                rs.getDouble("UccMaxEntradaA"),
                                rs.getDouble("RendimentoNacional"),
                                rs.getDouble("RendimentoMaximo"),
                                Inversor.PegaTipoSaidaAC_porTexto(rs.getString("TipoSaidaAC")),
                                rs.getDouble("ValorVenda"),
                                rs.getInt("Saldo")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Inversores: " + e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }
        return inversores;
    }

    public Inversor GetById(int pId) {
        this.setId(pId);
        return this.GetAll(0).get(0);
    }

    public List<Inversor> GetByModelo(String pModelo, int pMaxResult) {
        this.setModelo(pModelo);
        return this.GetAll(pMaxResult);
    }

    public Inversor Update(Inversor inversor) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DataConnection.getConnection();
            stmt = con.prepareStatement(UpdateCMD);
            int i = 1;
            stmt.setInt(i++, inversor.getStatus().getId());
            stmt.setString(i++, inversor.getModelo());
            stmt.setInt(i++, inversor.getPotenciaWCA());
            stmt.setInt(i++, inversor.getPotenciaMaxWCC());
            stmt.setDouble(i++, inversor.getIccMaxEntradaA());
            stmt.setDouble(i++, inversor.getUccMaxEntradaA());
            stmt.setDouble(i++, inversor.getRendimentoNacional());
            stmt.setDouble(i++, inversor.getRendimentoMaximo());
            stmt.setDouble(i++, inversor.getValorVenda());
            stmt.setString(i++, inversor.getTipoSaidaAC().toString());
            stmt.setInt(i++, inversor.getId());
            stmt.executeUpdate();
            Utilitarios.MsgSucesso();
        } catch (SQLException e) {
            Utilitarios.MsgExcecao("Erro ao tentar atualizar Inversor: " + e);
        } finally {
            DataConnection.closeConnection(con, stmt);
        }
        return this.GetById(inversor.getId());
    }

    public Inversor Delete(int pId) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DataConnection.getConnection();
            if (this.GetById(pId).getId() > 1) {
                stmt = con.prepareStatement("delete from Inversor where Id = ?");
                stmt.setInt(1, pId);
                stmt.executeUpdate();
                Utilitarios.MsgExclusao();
            }
        } catch (SQLException e) {
            Utilitarios.MsgExcecao(e.getMessage());
        } finally {
            DataConnection.closeConnection(con, stmt);
        }
        return new Inversor();
    }
}
