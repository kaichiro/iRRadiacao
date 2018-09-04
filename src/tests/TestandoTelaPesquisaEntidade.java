package tests;

import model.bean.Projeto;
import view.DlgPesquisaEntidade;

public class TestandoTelaPesquisaEntidade {

    public static void main(String[] abc12) {
//        String str = "98";
//        System.out.println(str.subSequence(0, 1));
//        String[] RangeNumber = ("0,1,2,3,4,5,6,7,8,9").split(",");
//        String Resultado = "";
//        for (int i = 0; i < str.length(); i++) {
//            for (int j = 0; j < RangeNumber.length; j++) {
//                System.out.println("i(" + i + "), j(" + j + ")");
//                System.out.println(" " + String.valueOf(str.subSequence(i, 1 + i)) + " == " + RangeNumber[j]);
//                if (String.valueOf(str.subSequence(i, 1 + i)).equals(RangeNumber[j])) {
//                    Resultado += String.valueOf(str.subSequence(i, 1));
//                }
//            }
//        }
//        System.out.println(Integer.parseInt(Resultado));

//        Class classe = Cliente.class;
//        String[] CamposPesquisaCombo = new String[]{"Nome", "Id"};
//        String[] ColunasJTable = new String[]{"Id", "Razãp Social / Nome", "Tipo", "CNPJ / CPF", "Status"};
//        Class classe = Inversor.class;
//        String[] CamposPesquisaCombo = new String[]{"Modelo", "Id"};
//        String[] ColunasJTable = new String[]{"Id", "Modelo", "Status"};

        Class classe = Projeto.class;
        String[] CamposPesquisaCombo = new String[]{"Cliente", "Id"};
        String[] ColunasJTable = new String[]{"Id", "Cliente", "Data Criação", "Status"};

        DlgPesquisaEntidade dlg = new DlgPesquisaEntidade(null, true, classe, CamposPesquisaCombo, ColunasJTable, false);
        dlg.setVisible(true);
        dlg.toFront();

    }
}
