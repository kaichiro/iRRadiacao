package controller;

import java.util.List;
import model.bean.EntradaProduto;
import model.dao.EntradaProdutoDAO;
import utils.Utilitarios;

public class EntradaProdutoCTRL {

    public static EntradaProduto BuscarPorId(int id) {
        return new EntradaProdutoDAO().GetById(id);
    }

    public static List<EntradaProduto> BuscarPorFornecedor(int Limite, String Nome) {
        return new EntradaProdutoDAO().GetByFornecedor(Nome, Limite);
    }

    public static EntradaProduto BuscarApenasUltimoRegistro() {
        return new EntradaProdutoDAO().GetLastRecord();
    }

    public static EntradaProduto Gravar(EntradaProduto ep) {
        return new EntradaProdutoDAO().Persists(ep);
    }

    public static void Deletar(int id) {
        Utilitarios.ExcluirObjetos(id, EntradaProduto.class);
    }
}
