package controller;

import java.util.List;
import model.bean.Projeto;
import model.dao.ProjetoDAO;

public class ProjetoCTRL {

    public static Projeto Gravar(Projeto projeto) {
        return new ProjetoDAO().Persist(projeto);
    }

    public static Projeto BuscarPorId(int id) {
        return new ProjetoDAO().GetById(id);
    }

    public static List<Projeto> BuscarPorCliente(int limite, String cliente) {
        return new ProjetoDAO().GetByCliente(limite, cliente);
    }

    public static List<Projeto> BuscarTodos(int Limite) {
        return new ProjetoDAO().GetAll(Limite, false, 0, null);
    }
}
