package controller;

import java.sql.Connection;
import java.util.List;
import model.bean.Cliente;
import model.bean.NecessidadeEnergeticaCliente;
import model.dao.ClienteDAO;

public class ClienteCTRL {

    public static List<Cliente> BuscarTodos(int MaximoRegistros, Connection pCon) {
        return new ClienteDAO().GetAll(MaximoRegistros, 0, "", false);
    }

    public static List<Cliente> BuscarPorNome(int MaximoRegistros, String Nome, Connection pCon) {
        return new ClienteDAO().GetAll(MaximoRegistros, 0, Nome, false);
    }

    public static Cliente BuscarPorId(int MaximoRegistros, int Id, Connection pCon) {
        return new ClienteDAO().GetAll(MaximoRegistros, Id, "", false).get(0);
    }

    public static void Excluir(int Id) {
        new ClienteDAO().Delete(Id);
    }

    public static Cliente Gravar(Cliente cliente, Connection pCon) {
        return new ClienteDAO().Persist(cliente);
    }

    public static boolean JaExiteRegistroComMesmoCNPJouCPF(Cliente c_) {
        return ClienteDAO.AlreadyExistingCNPJorCPF(c_);
    }

    public static NecessidadeEnergeticaCliente BuscaNecessidadeEnergetica(int idCliente) {
        return new ClienteDAO().GetNecessidadeEnergetica(BuscarPorId(1, idCliente, null));
    }
}
