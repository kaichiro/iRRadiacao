package tests;

import javax.swing.JOptionPane;
import model.bean.Usuario;
import view.DlgPesquisaEntidade;
import view.DlgUsuarioNEW;

public class TestandoUsuario {

    public static void main(String[] abc123) {
        if (JOptionPane.showConfirmDialog(null, "Yes = novo\r\nNo = pesquisa", "Escolha", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            DlgUsuarioNEW dlg = new DlgUsuarioNEW(null, true, new Usuario(0));
            dlg.setVisible(true);
            dlg.toFront();
        } else {
            DlgPesquisaEntidade dlg = new DlgPesquisaEntidade(null, true, Usuario.class, null, null, false);
            dlg.setVisible(true);
            dlg.toFront();
        }
    }
}
