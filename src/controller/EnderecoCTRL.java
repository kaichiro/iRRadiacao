package controller;

import java.util.List;
import model.bean.Cliente;
import model.bean.Endereco;
import model.dao.EnderecoDAO;

public class EnderecoCTRL {

    public static List<Endereco> BuscarPorCliente(Cliente cli) {
        return new EnderecoDAO().GetByCliente(cli);
    }

    public static Endereco BuscarPorID(int idEnder) {
        return new EnderecoDAO().GetById(idEnder);
    }

    public static void Deletar(Endereco e) {
        new EnderecoDAO().Delete(e);
    }

    public static Endereco Gravar(Endereco e) {
        return new EnderecoDAO().Persist(e);
    }
}
