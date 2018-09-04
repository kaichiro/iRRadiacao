package model.dao;

import connection.DataConnection;
import controller.StatusCTRL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Usuario;
import utils.Utilitarios;

public class UsuarioDAO {

    private boolean onlyLastRecord = false;

    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private boolean isOnlyLastRecord() {
        return onlyLastRecord;
    }

    private void setOnlyLastRecord(boolean onlyLastRecord) {
        this.onlyLastRecord = onlyLastRecord;
    }

    /**
     *
     * @param Id ID do usuário ou 0 (zero) para buscar todos
     * @param Login *Login
     * @param Senha *Senha
     * @param Nome
     * @return Retorna uma coleção de Usuario
     *
     * *Preencher este quando utilizar para validar usuário
     */
    public List<Usuario> GetAll(int Id, String Login, String Senha, String Nome) {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            con = DataConnection.getConnection();
            String SelectCMD = "select Id, Login, Senha, Status, Nome, PerfilGrupo from Usuario where 1 = 1 ";

            if (this.isOnlyLastRecord()) {
                stmt = con.prepareStatement(SelectCMD.concat(" order by Id desc limit 1 "));
            } else if (Id > 0) {
                stmt = con.prepareStatement(SelectCMD.concat(" and Id = ? "));
                stmt.setInt(1, Id);
            } else if (Login.trim().length() > 0 && Senha.trim().length() > 0) {
                stmt = con.prepareStatement(SelectCMD.concat(" and Login = ? and Senha = ? "));
                stmt.setString(1, Login);
                stmt.setString(2, Senha);
            } else if (Login.trim().length() > 0 && Senha.trim().length() == 0) {
                stmt = con.prepareStatement(SelectCMD.concat(" and Login like ? "));
                stmt.setString(1, "%" + Login + "%");
            } else if (Nome.trim().length() > 0) {
                stmt = con.prepareStatement(SelectCMD.concat(" and Nome like ? "));
                stmt.setString(1, "%" + Nome + "%");
            } else {
                stmt = con.prepareStatement(SelectCMD);
            }

            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("Id"));
                u.setLogin(rs.getString("Login"));
                u.setSenha(rs.getString("Senha"));
                u.setStatus(StatusCTRL.BuscaPorId(rs.getInt("Status")));
                u.setNome(rs.getString("Nome"));
                u.setPerfilGrupo(Usuario.PerfilGrupo.valueOf(rs.getString("PerfilGrupo")));
                usuarios.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Usuarios: " + e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }
        if (usuarios.isEmpty()) {
            usuarios.add(new Usuario());
        }
        return usuarios;
    }

    public Usuario GetById(int id) {
        return this.GetAll(id, "", "", "").get(0);
    }

    public List<Usuario> GetByNome(String Nome) {
        return this.GetAll(0, "", "", Nome);
    }

    public List<Usuario> GetByLogin(String Login) {
        return this.GetAll(0, Login, "", "");
    }

    public Usuario Insert(Usuario usuario) {
        try {
            con = DataConnection.getConnection();
            stmt = con.prepareStatement("insert into Usuario set Login = ?, Senha = ?, Status = ? , Nome = ?;");
            int i = 1;
            stmt.setString(i++, usuario.getLogin());
            stmt.setString(i++, usuario.getSenha());
            stmt.setInt(i++, usuario.getStatus().getId());
            stmt.setString(i++, usuario.getNome());
            stmt.executeUpdate();
            Utilitarios.MsgSucesso();
        } catch (SQLException e) {
            Utilitarios.MsgExcecao("Erro ao incluir Usuario: " + e.getMessage());
        } finally {
            DataConnection.closeConnection(con, stmt);
        }
        this.setOnlyLastRecord(true);
        return this.GetAll(0, "", "", "").get(0);
    }

    public Usuario Update(Usuario usuario) {
        try {
            con = DataConnection.getConnection();
            stmt = con.prepareStatement("update Usuario set Login = ?, Senha = ?, Status = ? , Nome = ? where Id = ?;");
            int i = 1;
            stmt.setString(i++, usuario.getLogin());
            stmt.setString(i++, usuario.getSenha());
            stmt.setInt(i++, usuario.getStatus().getId());
            stmt.setString(i++, usuario.getNome());
            stmt.setInt(i++, usuario.getId());
            stmt.executeUpdate();
            Utilitarios.MsgSucesso();
        } catch (SQLException e) {
            Utilitarios.MsgExcecao("Erro ao Atualizar Usuario: " + e.getMessage());
        } finally {
            DataConnection.closeConnection(con, stmt);
        }
        return usuario;
    }

    public Usuario Persists(Usuario usuario) {
        try {
            con = DataConnection.getConnection();
            String Fields = "Login = ?, Senha = ?, Status = ?, Nome = ?, PerfilGrupo = ?";
            String Insert = "insert into Usuario set ".concat(Fields);
            String Update = "update Usuario set " + Fields + " where Id = ?";

            if (usuario.IsNew()) {
                stmt = con.prepareStatement(Insert);
            } else {
                stmt = con.prepareStatement(Update);
            }
            int i = 1;
            stmt.setString(i++, usuario.getLogin());
            stmt.setString(i++, usuario.getSenha());
            stmt.setInt(i++, usuario.getStatus().getId());
            stmt.setString(i++, usuario.getNome());
            stmt.setString(i++, usuario.getPerfilGrupo().toString());
            if (!usuario.IsNew()) {
                stmt.setInt(i++, usuario.getId());
            }
            stmt.executeUpdate();
            Utilitarios.MsgSucesso();
        } catch (SQLException e) {
            Utilitarios.MsgExcecao("Erro ao " + (usuario.IsNew() ? "Inserir" : "Atualizar") + " Usuario: " + e.getMessage());
        } finally {
            DataConnection.closeConnection(con, stmt);
        }
        if (usuario.IsNew()) {
            this.setOnlyLastRecord(true);
            return this.GetAll(0, "", "", "").get(0);
        } else {
            return this.GetAll(usuario.getId(), "", "", "").get(0);
        }
    }
}
