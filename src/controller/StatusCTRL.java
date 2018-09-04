package controller;

import java.util.List;
import model.bean.Status;
import model.dao.StatusDAO;

public class StatusCTRL {

    public static List<Status> BuscaTodos() {
        return new StatusDAO().GetAll();
    }

    public static Status BuscaPorId(int i) {
        return new StatusDAO().GetById(i);
    }

    public static List<Status> BuscaPorDescricao(String s) {
        return new StatusDAO().GetByDescricao(s);
    }

    public static void Novo(String descricao) {
        new StatusDAO().Insert(descricao);
    }

    public static void Atualiza(Status s) {
        new StatusDAO().Update(s);
    }
}
