package controller;

import java.util.List;
import model.bean.IrradiacaoGlobalMes;
import model.dao.IrradiacaoGlobalMesDAO;

public class IrradiacaoGlobalMesCTRL {

    public static List<IrradiacaoGlobalMes> BuscarTodos(int MaxRecordCount) {
        return new IrradiacaoGlobalMesDAO().GetAll(MaxRecordCount, 0, 0, 0);
    }

    public static IrradiacaoGlobalMes BuscarPorId(int pId) {
        return new IrradiacaoGlobalMesDAO().GetByID(pId);
    }

    public static IrradiacaoGlobalMes Grava(IrradiacaoGlobalMes igm) {
        if (igm.getId() > 0) {
            return new IrradiacaoGlobalMesDAO().Update(igm);
        } else {
            return new IrradiacaoGlobalMesDAO().Insert(igm);
        }
    }

    public static IrradiacaoGlobalMes BuscarPorCoordenadas(double pLatitude, double pLongitude) {
        return new IrradiacaoGlobalMesDAO().GetByCoordenadas(pLatitude, pLongitude);
    }
}
