package tests;

import javax.swing.JOptionPane;
import model.bean.Projeto;
import view.DlgPesquisaEntidade;
import view.DlgProjetoNew;

public class TestandoProjeto {

    public static void main(String[] abc132) {
//        Projeto projeto = new Projeto();
//        projeto.setCliente(ClienteCTRL.BuscarPorId(0, 9, null));
//        projeto.setStatus(StatusCTRL.BuscaPorId(1));
//
//        ProjetoCTRL.Gravar(projeto);
//
//        List<ItemProjeto> itens = new ArrayList<>();
//
//        ItemProjeto item1 = new ItemProjeto();
//        item1.setQuantidade(2);
//        item1.setValorUnitario(15.99);
//        System.out.println("Quantidade  Item 1: " + item1.getQuantidade());
//        System.out.println("Valor Unit  Item 1: " + item1.getValorUnitario());
//        System.out.println("Valor total Item 1: " + item1.getValorTotal());
//        System.out.println("");
//        itens.add(item1);
//        projeto.setItens(itens);
//
//
//        System.out.println("tot prod: " + projeto.getTotalProdutos());
//        System.out.println("acres   : " + projeto.getAcrescimo());
//        System.out.println("desc    : " + projeto.getDesconto());
//        System.out.println("total   : " + projeto.getTotalLiquido());
//
//
//        System.out.println(" Acrescentando outro item");
//        ItemProjeto item2 = new ItemProjeto();
//        item2.setQuantidade(5);
//        item2.setValorUnitario(25.99);
//        System.out.println("Quantidade  Item 1: " + item2.getQuantidade());
//        System.out.println("Valor Unit  Item 1: " + item2.getValorUnitario());
//        System.out.println("Valor total Item 1: " + item2.getValorTotal());
//        System.out.println("");
//        itens.add(item2);
//        projeto.setItens(itens);
//
//
//        System.out.println("Valores Atualizado=====>>>>>");
//        System.out.println("tot prod: " + projeto.getTotalProdutos());
//        System.out.println("acres   : " + projeto.getAcrescimo());
//        System.out.println("desc    : " + projeto.getDesconto());
//        System.out.println("total   : " + projeto.getTotalLiquido());
//
//
//        projeto.setAcrescimo(2.26);
//        projeto.setDesconto(.24);
//
//
//        Map params = new HashMap();
//        params.put("idProj", 3);
//        new ManagerJasperReport().ExecutaRelatorio("ProjetoNew", "Projeto", params);
//

//        JDialog d = new JDialog(new javax.swing.JFrame(), "testando modal maximizado", true);
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        Dimension screenSize = tk.getScreenSize();
//        d.setSize(screenSize.width, screenSize.height);
//        d.setVisible(true);
//        d.toFront();
//
//
        if (JOptionPane.showConfirmDialog(null, "Yes = novo\r\nNo = pesquisa", "Escolha", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            DlgProjetoNew dlg = new DlgProjetoNew(null, true, new Projeto(0));
            dlg.setVisible(true);
            dlg.toFront();
        } else {
            DlgPesquisaEntidade dlg = new DlgPesquisaEntidade(null, true, Projeto.class, null, null, false);
            dlg.setVisible(true);
            dlg.toFront();
        }
//
//        Object[][] obj = new Object[][]{{"k1", "v1"}, {"k2", "v2"}};
//        System.out.println(obj.length);
//
//        double PotenciaModulo = 325;
//        double ConsumoEnergetico = 650 + 1;
//        double ResultadoBruto = ConsumoEnergetico / PotenciaModulo;
//        int ResultadoInteiro = (int) ResultadoBruto;
//        System.out.println(
//                +(((ResultadoBruto - ResultadoInteiro) > 0 ? 1 : 0) + ResultadoInteiro)
//        );
    }
}
