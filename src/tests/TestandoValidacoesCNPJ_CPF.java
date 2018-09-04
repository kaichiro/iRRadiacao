package tests;

import controller.TipoPessoaCTRL;
import model.bean.Cliente;

public class TestandoValidacoesCNPJ_CPF {

    public static void main(String[] abc123) {

        Cliente c = new Cliente();
        c.setTipoPessoa(TipoPessoaCTRL.BuscaPorDescricao("Pessoa F%sica").get(0));
        c.setCNPJ_CPF("013.271.161-38");
//        System.out.println("CPF válido: " + c.IsCPF_CNPJ_Valid());

    }
}
