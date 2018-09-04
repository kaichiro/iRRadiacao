package controller;

import java.util.List;
import model.bean.Usuario;
import model.dao.UsuarioDAO;

public class UsuarioCTRL {

    public static List<Usuario> BuscarTodos() {
        return new UsuarioDAO().GetAll(0, "", "", "");
    }

    public static Usuario Novo(Usuario usuario) {
        return new UsuarioDAO().Insert(usuario);
    }

    public static Usuario Atualiza(Usuario usuario) {
        return new UsuarioDAO().Update(usuario);
    }

    public static Usuario UsuarioExisttente(String Login, String Senha) {
        return new UsuarioDAO().GetAll(0, Login, Senha, "").get(0);
    }

    public static Usuario BuscarPorId(int id) {
        return new UsuarioDAO().GetById(id);
    }

    public static List<Usuario> BuscarPorNome(String Nome) {
        return new UsuarioDAO().GetByNome(Nome);
    }

    public static List<Usuario> BuscarPorLogin(String Login) {
        return new UsuarioDAO().GetByLogin(Login);
    }

    public static Usuario Persite(Usuario usuario) {
        return new UsuarioDAO().Persists(usuario);
    }
}
