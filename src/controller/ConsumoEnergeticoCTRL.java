package controller;

import java.util.List;
import model.bean.ConsumoEnergetico;
import model.bean.UnidadeConsumidora;
import model.dao.ConsumoEnergeticoDAO;

public class ConsumoEnergeticoCTRL {

    public static ConsumoEnergetico BuscarPorId(int pId) {
        return new ConsumoEnergeticoDAO().GetAll(pId, null, false).get(0);
    }

    public static List<ConsumoEnergetico> BuscaPorUnidadeConsumidora(UnidadeConsumidora pUC) {
        return new ConsumoEnergeticoDAO().GetAll(0, pUC, false);
    }

    public static ConsumoEnergetico Gravar(ConsumoEnergetico pCE) {
        return new ConsumoEnergeticoDAO().Persit(pCE);
    }
}
