package controller;

import java.util.List;
import model.bean.EntradaProduto;
import model.bean.ItemEntrada;
import model.dao.ItemEntradaDAO;
import utils.Utilitarios;

public class ItemEntradaCTRL {

    public static List<ItemEntrada> BuscarPorEntrada(EntradaProduto ep) {
        return new ItemEntradaDAO().GetByEntrada(ep);
    }

    public static ItemEntrada Gravar(ItemEntrada ie) {
        return new ItemEntradaDAO().Persists(ie);
    }

    public static void Deletar(int i) {
        Utilitarios.ExcluirObjetos(i, ItemEntrada.class);
    }
}
