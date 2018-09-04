package controller;

import java.util.List;
import model.bean.Inversor;
import model.dao.InversorDAO;

public class InversorCTRL {

    public static List<Inversor> BuscaTodos(int pLimite) {
        return new InversorDAO().GetAll(pLimite);
    }

    public static Inversor BuscaPorId(int pId) {
        return new InversorDAO().GetById(pId);
    }

    public static List<Inversor> BuscaPorModelo(String pModelo, int pLimite) {
        return new InversorDAO().GetByModelo(pModelo, pLimite);
    }

    public static Inversor Atualiza(Inversor inversor) {
        return new InversorDAO().Update(inversor);
    }

    public static Inversor Novo(Inversor i) {
        return new InversorDAO().Insert(i);
    }

    public static Inversor Grava(Inversor i) {
        if (i.IsNew()) {
            return new InversorDAO().Insert(i);
        } else {
            return new InversorDAO().Update(i);
        }
    }

    public static Inversor Apaga(int pID) {
        return new InversorDAO().Delete(pID);
    }
}
