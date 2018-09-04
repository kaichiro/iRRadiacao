package tests;

import javax.swing.JOptionPane;
import model.bean.Cliente;
import view.DlgClienteNEW1;
import view.DlgPesquisaEntidade;

public class TestandoClienteNEW1 {

    public static void main(String[] abc123) {

        if (JOptionPane.showConfirmDialog(null, "Yes = novo\r\nNo = pesquisa", "Escolha", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            DlgClienteNEW1 dlg = new DlgClienteNEW1(null, true, new Cliente(0));
            dlg.setVisible(true);
            dlg.toFront();
        } else {
            DlgPesquisaEntidade dlg = new DlgPesquisaEntidade(null, true, Cliente.class, null, null, false);
            dlg.setVisible(true);
            dlg.toFront();
        }
    }
}
