package tests;

import javax.swing.JOptionPane;
import model.bean.Inversor;
import view.DlgInversorNEW;
import view.DlgPesquisaEntidade;

public class TestandoInversor {

    public static void main(String[] abc) {

//        System.out.println("Incluindo Inversor");
//        System.out.println(InversorCTRL.Novo(new Inversor(StatusCTRL.BuscaPorId(1), "modelo de teste", 1, 1, 1, 2, 3, 4, Inversor.TipoSaidaAC.Monofásico)).toString());
//        System.out.println("Buscando todos Inversores");
//        InversorCTRL.BuscaTodos().forEach((Inversor i) -> {
//            System.out.println(i.toString());
//        });
//        Inversor i = InversorCTRL.BuscaPorId(5);
//        i.setStatus(StatusCTRL.BuscaPorId(2));
//        i.setModelo(i.getModelo().concat(" - modificado"));
//        InversorCTRL.Atualiza(i);
//        InversorCTRL.Apaga(4);
        if (JOptionPane.showConfirmDialog(null, "Yes = novo\r\nNo = pesquisa", "Escolha", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            DlgInversorNEW dlg = new DlgInversorNEW(null, true, new Inversor(0));
            dlg.setVisible(true);
            dlg.toFront();
        } else {
            DlgPesquisaEntidade dlg = new DlgPesquisaEntidade(null, true, Inversor.class, null, null, false);
            dlg.setVisible(true);
            dlg.toFront();
        }

    }
}
