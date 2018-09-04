package model.dao;

import connection.DataConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Status;

public class StatusDAO {

    private int Id = 0;
    private String Descricao = "";
    private String SelectCMD = "select s.Id, s.Descricao from Status s";
    private final String InsertCMD = "insert into Status set Descricao = ?;";
    private final String UpdateCMD = "update status set Descricao = ? where Id = ?;";

    public List<Status> GetAll() {
        List<Status> statusList = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = DataConnection.getConnection();
            if (this.getId() > 0) {
                SelectCMD += " where s.Id = ?";
                stmt = con.prepareStatement(SelectCMD);
                stmt.setInt(1, this.getId());
            } else if (this.getDescricao().trim().length() > 0) {
                SelectCMD += " where s.Descricao like ?";
                stmt = con.prepareStatement(SelectCMD);
                stmt.setString(1, ("%").concat(this.getDescricao().concat("%")));
            } else {
                SelectCMD += " order by Id";
                stmt = con.prepareStatement(SelectCMD);
            }

            rs = stmt.executeQuery();
            while (rs.next()) {
                Status s = new Status(rs.getInt("Id"), rs.getString("Descricao"));
                statusList.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao tentar buscar Status: " + e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }
        return statusList;
    }

    public Status GetById(int pId) {
        this.setId(pId);
        return this.GetAll().get(0);
    }

    public List<Status> GetByDescricao(String pDescricao) {
        this.setDescricao(pDescricao);
        return this.GetAll();
    }

    public void Insert(String pDescricao) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DataConnection.getConnection();
            stmt = con.prepareStatement(InsertCMD);
            stmt.setString(1, pDescricao);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Status: " + e);
        } finally {
            DataConnection.closeConnection(con, stmt);
        }
    }

    public void Update(Status pStatus) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DataConnection.getConnection();
            stmt = con.prepareStatement(UpdateCMD);
            stmt.setString(1, pStatus.getDescricao());
            stmt.setInt(2, pStatus.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao tentar atualiza Status: " + e);
        } finally {
            DataConnection.closeConnection(con, stmt);
        }
    }

    private int getId() {
        return Id;
    }

    private void setId(int Id) {
        this.Id = Id;
    }

    private String getDescricao() {
        return Descricao;
    }

    private void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
}
