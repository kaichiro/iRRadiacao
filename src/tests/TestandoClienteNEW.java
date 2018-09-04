package tests;

import javax.swing.JOptionPane;
import model.bean.Cliente;
import view.DlgClienteNEW;
import view.DlgPesquisaEntidade;

public class TestandoClienteNEW {

    public static void main(String[] abc123) {

//        System.out.println(CEPEnderecoCTRL.BuscarPorId(434005).toString());

        int retorno = JOptionPane.showConfirmDialog(null, "(Yes) para novo e (No) para pesquisar", "Escolha", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (retorno == 0) {
            DlgClienteNEW dlg = new DlgClienteNEW(null, true, new Cliente());
            dlg.setVisible(true);
            dlg.toFront();
        } else if (retorno == 1) {
            DlgPesquisaEntidade dlg = new DlgPesquisaEntidade(null, true, Cliente.class, null, null, false);
            dlg.setVisible(true);
            dlg.toFront();
        }
    }
}
