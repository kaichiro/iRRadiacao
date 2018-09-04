package tests;

import controller.ClienteCTRL;
import controller.IrradiacaoGlobalMesCTRL;
import controller.StatusCTRL;
import controller.TipoPessoaCTRL;
import java.util.ArrayList;
import java.util.List;
import model.bean.Cliente;
import model.bean.Contato;
import model.bean.Endereco;
import utils.Enumeradors;

public class TestandoCliente2 {

    public static void main(String[] abc123) {
        // Instanciando Pessoa
        Cliente cliente = new Cliente();
        cliente.setCNPJ_CPF("013.271.161-38");
        cliente.setIE_RG("4662889");
        cliente.setNomeFantasia_Apelido("Fukuda");
        cliente.setRazaoSocial_Nome("Kaichiro Fukuda");
        cliente.setStatus(StatusCTRL.BuscaPorId(1));
        cliente.setTipoPessoa(TipoPessoaCTRL.BuscaPorId(2));

        List<Endereco> enderecos = new ArrayList<>();
        // Instanaciando Endereco1
        Endereco endereco1 = new Endereco();
        endereco1.setCEP("74.275-170");
        endereco1.setCidade("Goiânia");
        endereco1.setCliente(cliente);
        endereco1.setComplemento("Qd-363, Lt-15");
        endereco1.setIrradiacaoGlobalMes(IrradiacaoGlobalMesCTRL.BuscarPorId(11));
        endereco1.setLogradouro("Rua C-165");
        endereco1.setNumero("02");
        endereco1.setUF(Enumeradors.UF.GO);
        enderecos.add(endereco1);
        cliente.setEnderecos(enderecos);

        List<Contato> contatos = new ArrayList<>();
        contatos.add(new Contato("+55 62 9 9111 9204", cliente));
        contatos.add(new Contato("k.fukuda@omnia.inf.br", cliente));
        contatos.add(new Contato("kcfg23@gmail.com", cliente));
        contatos.add(new Contato("+55 62 3093 7826", cliente));
        cliente.setContatos(contatos);

        ClienteCTRL.Gravar(cliente, null);
    }
}
