package utils;

import connection.DataConnection;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Classe responsável por emitir relatórios (Jasper)
 */
public class ManagerJasperReport {

    /**
     * Método que emite relatório Jasper na tela
     *
     * @param ReportName apenas o nome do arquivo de relatório .jasper (arquivo
     * já compilado pelo Jasper).
     * @param ReportTitle
     * @param Params
     */
    public /*static */ void ExecutaRelatorio(String ReportName, String ReportTitle, Map Params) {
        try {
            Connection con = DataConnection.getConnection();
            ExecutaRelatorio(ReportName, ReportTitle, Params, con);
        } catch (SQLException e) {
            Logger.getLogger(ManagerJasperReport.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Error methodo ExecutaRelatorio(String): " + e);
            JOptionPane.showMessageDialog(null, "Error methodo ExecutaRelatorio(String): " + e);
        }
    }

    /**
     * Método que emite relatório Jasper na tela
     *
     * @param ReportName apenas o nome do arquivo (NomeRelatorio.jasper) de
     * relatório (arquivo já compilado pelo Jasper).
     * @param conn objeto Connection (objeto de conexão com base de dados)
     * @param Params
     * @param ReportTitle
     */
    public /*static */ void ExecutaRelatorio(String ReportName, String ReportTitle, Map Params, Connection conn) {
        try {
            JasperPrint jaspertPrint = null;
            jaspertPrint = JasperFillManager.fillReport(/*".\\src\\reports\\" +*/ReportName + ".jasper", Params, conn);
            JasperViewer view = new JasperViewer(jaspertPrint, false);
            view.setTitle(ReportTitle);
            view.setVisible(true);
            view.toFront();
            view.setModalExclusionType(Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
            view.setExtendedState(Frame.MAXIMIZED_BOTH);

            JDialog d = new JDialog(new javax.swing.JFrame(), ReportTitle, true);
            d.getContentPane().add(view.getContentPane());
            Toolkit tk = Toolkit.getDefaultToolkit();
            Dimension screenSize = tk.getScreenSize();
            d.setSize(screenSize.width, (int) (screenSize.height * .95));
            view.setVisible(false);
            d.setVisible(true);
            d.toFront();

        } catch (JRException ex) {
            Logger.getLogger(ManagerJasperReport.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error JasperFillManager.fillReport(src, null, conn): " + ex);
            JOptionPane.showMessageDialog(null, "Error JasperFillManager.fillReport(src, null, conn): " + ex);
        } finally {
            DataConnection.closeConnection(conn);
        }
    }

}
