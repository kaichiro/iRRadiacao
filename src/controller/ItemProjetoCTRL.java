package controller;

import java.util.List;
import model.bean.ItemProjeto;
import model.bean.Projeto;
import model.dao.ItemProjetoDAO;
import utils.Utilitarios;

public class ItemProjetoCTRL {

    public static List<ItemProjeto> BuscarPorProjeto(Projeto pProjeto) {
        return new ItemProjetoDAO().GetAll(0, pProjeto, false);
    }

    public static ItemProjeto Grava(ItemProjeto item) {
        return new ItemProjetoDAO().Persist(item);
    }

    public static void Deletar(int id) {
        Utilitarios.ExcluirObjetos(id, ItemProjeto.class);
    }
}
