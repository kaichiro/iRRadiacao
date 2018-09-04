package tests;

import javax.swing.JOptionPane;
import model.bean.EntradaProduto;
import view.DlgEntradaProduto;
import view.DlgPesquisaEntidade;

public class TestandoEntradaProduto {

    public static void main(String[] abc321) {
//        EntradaProdutoCTRL.BuscarTodasEntradasDeProdutos().forEach((EntradaProduto ep) -> {
//            System.out.println(ep.toString());
//        });
//
//        System.out.println(EntradaProdutoCTRL.BuscarPorId(1));
//
//        System.out.println(EntradaProdutoCTRL.BuscarPorFornecedor("forne"));
//
//        System.out.println(EntradaProdutoCTRL.BuscarApenasUltimoRegistro().toString());
//
//        EntradaProduto ep = new EntradaProduto();
//        ep.setDescontos(12);
//        ep.setFornecedor(FornecedorCTRL.BuscarUltimo());
//        System.out.println(EntradaProdutoCTRL.Gravar(ep).toString());
//
//        EntradaProduto ep = EntradaProdutoCTRL.BuscarApenasUltimoRegistro();
//        ep.setDescontos(23);
//        System.out.println(EntradaProdutoCTRL.Gravar(ep).toString());
//
//        System.out.println(EntradaProdutoCTRL.BuscarPorId(1).toString());
//
//        EntradaProduto ep = EntradaProdutoCTRL.BuscarApenasUltimoRegistro();
//        System.out.println(ep.toString());
//        ep.getItens().forEach((ItemEntrada ie) -> {
//            System.out.println(ie.toString());
//        });
//

//        EntradaProduto ep = new EntradaProduto(0);
//        ep.setDescontos(5);
//        ep.setFornecedor(FornecedorCTRL.BuscarUltimo());
//        
//        List<ItemEntrada> itens = new ArrayList<>();
//        
//        ItemEntrada ie1 = new ItemEntrada(0);
//        ie1.setEntradaProduto(ep);
//        ie1.setInversor(InversorCTRL.BuscaPorId(55));
//        ie1.setQuantidade(8);
//        ie1.setValorUnitario(448.96);
//        itens.add(ie1);
//
//        ItemEntrada ie2 = new ItemEntrada(0);
//        ie2.setEntradaProduto(ep);
//        ie2.setModulo(ModuloCTRL.BuscaPorId(93));
//        ie2.setQuantidade(14);
//        ie2.setValorUnitario(338.07);
//        itens.add(ie2);
//        
//        ep.setItens(itens);
//        
//        System.out.println(EntradaProdutoCTRL.Gravar(ep).toString());
//
        if (JOptionPane.showConfirmDialog(null, "Yes = novo\r\nNo = pesquisa", "Escolha", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            DlgEntradaProduto dlg = new DlgEntradaProduto(null, true, new EntradaProduto(0));
            dlg.setVisible(true);
            dlg.toFront();
        } else {
            DlgPesquisaEntidade dlg = new DlgPesquisaEntidade(null, true, EntradaProduto.class, null, null, false);
            dlg.setVisible(true);
            dlg.toFront();
        }
    }
}
