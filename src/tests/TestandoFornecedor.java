package tests;

import javax.swing.JOptionPane;
import model.bean.Fornecedor;
import view.DlgFornecedor;
import view.DlgPesquisaEntidade;

public class TestandoFornecedor {

    public static void main(String[] abc123) {
        if (JOptionPane.showConfirmDialog(null, "Yes = novo\r\nNo = pesquisa", "Escolha", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            DlgFornecedor dlg = new DlgFornecedor(null, true, new Fornecedor(0));
            dlg.setVisible(true);
            dlg.toFront();
        } else {
            DlgPesquisaEntidade dlg = new DlgPesquisaEntidade(null, true, Fornecedor.class, null, null, false);
            dlg.setVisible(true);
            dlg.toFront();
        }

//        Fornecedor f = new Fornecedor(0);
//        f.setBairro("bairro de teste");
//        f.setCEP("0123456");
//        f.setCNPJ("00.111.222/3333-44");
//        f.setCidade("cidade de teste");
//        f.setComplemento("complemento de teste");
//        f.setEmail("email de teste");
//        f.setEnderecoNumero("s/n");
//        f.setFone("8765-4321");
//        f.setIE("nao informado");
//        f.setIM("nao informado");
//        f.setLogradouro("logradouro de teste");
//        f.setNomeFantasia("nome fantasia de teste");
//        f.setRazaoSocial("razao social de teste");
//        f.setStatus(StatusCTRL.BuscaPorId(1));
//        f.setUF(Enumeradors.UF.GO);
//        
//        System.out.println(FornecedorCTRL.Gravar(f).toString());
//        System.out.println("========");
//
//        FornecedorCTRL.BuscarPorNome(10, "%").forEach((Fornecedor frn) -> {
//            System.out.println(frn.toString());
//        });
//
//        System.out.println(FornecedorCTRL.BuscarUltimo().toString());
//        FornecedorCTRL.Deletar(2);
//        System.out.println(FornecedorCTRL.BuscarUltimo().toString());
    }
}
