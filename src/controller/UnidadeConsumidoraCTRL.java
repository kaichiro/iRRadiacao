package controller;

import java.util.List;
import model.bean.Endereco;
import model.bean.UnidadeConsumidora;
import model.dao.UnidadeConsumidoraDAO;

public class UnidadeConsumidoraCTRL {

    public static UnidadeConsumidora Gravar(UnidadeConsumidora pUC) {
        return new UnidadeConsumidoraDAO().Persist(pUC);
    }

    public static List<UnidadeConsumidora> BuscarPorEndereco(Endereco pEndereco) {
        return new UnidadeConsumidoraDAO().GetByEndereco(0, pEndereco);
    }

    public static UnidadeConsumidora BuscarPorId(int pId) {
        return new UnidadeConsumidoraDAO().GetById(pId);
    }

}
