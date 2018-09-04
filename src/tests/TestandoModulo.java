package tests;

import controller.ModuloCTRL;
import javax.swing.JOptionPane;
import model.bean.Modulo;
import view.DlgModuloNEW;
import view.DlgPesquisaEntidade;

public class TestandoModulo {

    public static void main(String[] abc123) {
//        Modulo m2 = ModuloCTRL.BuscaPorId(2);
//        m2.setModelo("mais um modelo");
//        ModuloCTRL.Apaga(m2.getId());
        if (JOptionPane.showConfirmDialog(null, "Yes = novo\r\nNo = pesquisa", "Escolha", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            DlgModuloNEW dlg = new DlgModuloNEW(null, true, new Modulo(0));
            dlg.setVisible(true);
            dlg.toFront();
        } else {
            DlgPesquisaEntidade dlg = new DlgPesquisaEntidade(null, true, Modulo.class, null, null, false);
            dlg.setVisible(true);
            dlg.toFront();
        }
    }
}
