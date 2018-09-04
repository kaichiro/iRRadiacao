package model.dao;

import connection.DataConnection;
import controller.StatusCTRL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Modulo;
import utils.Utilitarios;

public class ModuloDAO {

    private int id = 0;
    private String descricao = "";
    private String modelo = "";
    private boolean onlyLastRecord = false;

    private String SelectCMD = "SELECT Id, Descricao, Modelo, PMaxWp, UocV, AlturaMM, LarguraMM, EspessuraMM, Eficiencia, SuperficieMM2, Status, ValorVenda, Saldo FROM Modulo ";
    private final String UpdateCMD = "UPDATE Modulo SET Descricao = ?, Modelo = ?, PMaxWp = ?, UocV = ?, AlturaMM = ?, LarguraMM = ?, EspessuraMM = ?, Status = ?, ValorVenda = ? WHERE Id = ?;";
    private final String InsertCMD = "INSERT INTO Modulo set Descricao = ?, Modelo = ?, PMaxWp = ?, UocV = ?, AlturaMM = ?, LarguraMM = ?, EspessuraMM = ?, Status = ?;";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isOnlyLastRecord() {
        return onlyLastRecord;
    }

    public void setOnlyLastRecord(boolean onlyLastRecord) {
        this.onlyLastRecord = onlyLastRecord;
    }

    public List<Modulo> GetAll(int pMaxResultRecord) {
        String Limite = pMaxResultRecord > 0 ? " limit " + pMaxResultRecord + " " : "";
        List<Modulo> modulos = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = DataConnection.getConnection();
            if (this.isOnlyLastRecord()) {
                SelectCMD += " order by Id desc limit 1" + Limite;
                stmt = con.prepareStatement(SelectCMD);
            } else if (this.getId() > 0) {
                SelectCMD += " where Id = ? " + Limite;
                stmt = con.prepareStatement(SelectCMD);
                stmt.setInt(1, this.getId());
            } else if (this.getDescricao().trim().length() > 0) {
                SelectCMD += " where Descricao like ? " + Limite;
                stmt = con.prepareStatement(SelectCMD);
                stmt.setString(1, ("%").concat(this.getDescricao().concat("%")));
            } else if (this.getModelo().trim().length() > 0) {
                SelectCMD += " where Modelo like ? " + Limite;
                stmt = con.prepareStatement(SelectCMD);
                stmt.setString(1, ("%").concat(this.getModelo().concat("%")));
            } else {
                SelectCMD += Limite;
                stmt = con.prepareStatement(SelectCMD);
            }
            rs = stmt.executeQuery();
            while (rs.next()) {
                modulos.add(
                        new Modulo(
                                rs.getInt("Id"),
                                rs.getString("Descricao"),
                                rs.getString("Modelo"),
                                rs.getInt("PMaxWp"),
                                rs.getDouble("UocV"),
                                rs.getInt("AlturaMM"),
                                rs.getInt("LarguraMM"),
                                rs.getInt("EspessuraMM"),
                                rs.getDouble("Eficiencia"),
                                rs.getDouble("SuperficieMM2"),
                                StatusCTRL.BuscaPorId(rs.getInt("Status")),
                                rs.getDouble("ValorVenda"),
                                rs.getInt("Saldo")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao tentar resgatar Modulos: " + e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }
//        if (modulos != null) {
//            modulos.add(new Modulo());
//        } else {
//        }
        return modulos;
    }

    public Modulo GetById(int pId) {
        this.setId(pId);
        return this.GetAll(0).get(0);
    }

    public List<Modulo> GetByModelo(String pModelo, int pMaxResult) {
        this.setModelo(pModelo);
        return this.GetAll(pMaxResult);
    }

    public List<Modulo> GetByDescricao(String pDescricao, int pMaxResult) {
        this.setDescricao(pDescricao);
        return this.GetAll(pMaxResult);
    }

    public Modulo Update(Modulo pModulo) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DataConnection.getConnection();
            stmt = con.prepareStatement(UpdateCMD);
            int i = 1;
            stmt.setString(i++, pModulo.getDescricao());
            stmt.setString(i++, pModulo.getModelo());
            stmt.setInt(i++, pModulo.getPMaxWp());
            stmt.setDouble(i++, pModulo.getUocV());
            stmt.setInt(i++, pModulo.getAlturaMM());
            stmt.setInt(i++, pModulo.getLarguraMM());
            stmt.setInt(i++, pModulo.getEspessuraMM());
            stmt.setInt(i++, pModulo.getStatus().getId());
            stmt.setDouble(i++, pModulo.getValorVenda());
            stmt.setInt(i++, pModulo.getId());
            stmt.executeUpdate();
            Utilitarios.MsgSucesso();
        } catch (SQLException e) {
            Utilitarios.MsgExcecao("Erro ao tentar atualizar Modulo: " + e);
        } finally {
            DataConnection.closeConnection(con, stmt);
        }
        return this.GetById(pModulo.getId());
    }

    public void Delete(int id) {
        Utilitarios.ExcluirObjetos(id, Modulo.class);
    }

    public Modulo Insert(Modulo modulo) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DataConnection.getConnection();
            stmt = con.prepareStatement(InsertCMD);
            int i = 1;
            stmt.setString(i++, modulo.getDescricao());
            stmt.setString(i++, modulo.getModelo());
            stmt.setInt(i++, modulo.getPMaxWp());
            stmt.setDouble(i++, modulo.getUocV());
            stmt.setInt(i++, modulo.getAlturaMM());
            stmt.setInt(i++, modulo.getLarguraMM());
            stmt.setInt(i++, modulo.getEspessuraMM());
            stmt.setInt(i++, modulo.getStatus().getId());
            stmt.execute();
            Utilitarios.MsgSucesso();
        } catch (SQLException e) {
            Utilitarios.MsgExcecao("Erro ao incluir Modulo: " + e);
        } finally {
            DataConnection.closeConnection(con, stmt);
        }
        this.setOnlyLastRecord(true);
        return this.GetAll(0).get(0);
    }
}
