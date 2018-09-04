package controller;

import java.util.List;
import model.bean.Fornecedor;
import model.dao.FornecedorDAO;

public class FornecedorCTRL {

    public static Fornecedor BuscarPorId(int id) {
        return new FornecedorDAO().GetById(id);
    }

    public static List<Fornecedor> BuscarPorNome(int limite, String nome) {
        return new FornecedorDAO().GetByName(nome, limite);
    }

    public static Fornecedor BuscarUltimo() {
        return new FornecedorDAO().GetLastRecord();
    }

    public static Fornecedor Gravar(Fornecedor fornecedor) {
        return new FornecedorDAO().Persists(fornecedor);
    }

    public static void Deletar(int id) {
        new FornecedorDAO().Delete(id);
    }
}
