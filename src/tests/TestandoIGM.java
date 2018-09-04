package tests;

import controller.IrradiacaoGlobalMesCTRL;
import javax.swing.JOptionPane;
import model.bean.IrradiacaoGlobalMes;
import view.DlgIrradiacaoGlobalMesNEW;
import view.DlgPesquisaEntidade;

public class TestandoIGM {

    public static void main(String[] abc123) {
//        if (JOptionPane.showConfirmDialog(null, "Yes = novo\r\nNo = pesquisa", "Escolha", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//            DlgIrradiacaoGlobalMesNEW dlg = new DlgIrradiacaoGlobalMesNEW(null, true, new IrradiacaoGlobalMes(0));
//            dlg.setVisible(true);
//            dlg.toFront();
//        } else {
//            DlgPesquisaEntidade dlg = new DlgPesquisaEntidade(null, true, IrradiacaoGlobalMes.class, null, null, false);
//            dlg.setVisible(true);
//            dlg.toFront();
//        }
        System.out.println(IrradiacaoGlobalMesCTRL.BuscarPorCoordenadas(-16.82, -49.24).asString());
    }
}
