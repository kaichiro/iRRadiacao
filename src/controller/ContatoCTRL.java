package controller;

import java.util.List;
import model.bean.Cliente;
import model.bean.Contato;
import model.dao.ContatoDAO;

public class ContatoCTRL {

    public static List<Contato> BuscarPorCliente(Cliente cli) {
        return new ContatoDAO().GetByCliente(cli);
    }

    public static Contato BuscarPorID(Contato e) {
        return new ContatoDAO().GetById(e.getCliente(), e.getId());
    }

    public static void Deletar(Contato e) {
        new ContatoDAO().Delete(e);
    }

    public static Contato Gravar(Contato e) {
        return new ContatoDAO().Persist(e);
    }
}
