package engine;

import connection.ConnectionProperties;
import java.awt.Frame;
import view.DlgLogin;
import view.FrmMain;

public class Engine {

    public static void main(String[] abc) {

        /**
         * Verificando (e criando quando necessário) os atributos para conexão a
         * base de dados%
         */
        ConnectionProperties connectionProperties = new ConnectionProperties();
//        System.out.println(connectionProperties);

        DlgLogin dlgLogin = new DlgLogin(null, true);
        dlgLogin.setVisible(true);
        dlgLogin.toFront();

        if (dlgLogin.usuario.getId() > 0) {
            FrmMain frmMain = new FrmMain(dlgLogin.usuario);
            frmMain.setVisible(true);
            frmMain.setExtendedState(Frame.MAXIMIZED_BOTH);
            frmMain.toFront();
        } else {
            System.exit(0);
        }
//            DlgLogin dlgLogin = new DlgLogin(null, true);
//            FrmMain frmMain = new FrmMain(dlgLogin.usuario);
//            frmMain.setVisible(true);
//            frmMain.setExtendedState(Frame.MAXIMIZED_BOTH);
//            frmMain.toFront();

    }
}
