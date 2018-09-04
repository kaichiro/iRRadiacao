package controller;

import java.util.List;
import model.bean.Modulo;
import model.dao.ModuloDAO;

public class ModuloCTRL {

    public static List<Modulo> BuscaTodos(int pLimite) {
        return new ModuloDAO().GetAll(pLimite);
    }

    public static Modulo Novo(Modulo i) {
        return new ModuloDAO().Insert(i);
    }

    public static Modulo BuscaPorId(int pId) {
        return new ModuloDAO().GetById(pId);
    }

    public static List<Modulo> BuscaPorModelo(String pModelo, int pLimite) {
        return new ModuloDAO().GetByModelo(pModelo, pLimite);
    }

    public static List<Modulo> BuscaPorDescricao(String pDescricao, int pLimite) {
        return new ModuloDAO().GetByDescricao(pDescricao, pLimite);
    }

    public static Modulo Atualiza(Modulo modulo) {
        return new ModuloDAO().Update(modulo);
    }

    public static void Apaga(int pID) {
        new ModuloDAO().Delete(pID);
    }

    public static Modulo Grava(Modulo m) {
        if (m.IsNew()) {
            return new ModuloDAO().Insert(m);
        } else {
            return new ModuloDAO().Update(m);
        }
    }
}
