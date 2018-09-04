package tests;

import controller.ClienteCTRL;
import controller.IrradiacaoGlobalMesCTRL;
import controller.StatusCTRL;
import controller.TipoPessoaCTRL;
import java.util.ArrayList;
import java.util.List;
import model.bean.Cliente;
import model.bean.Contato;
import model.bean.IrradiacaoGlobalMes;
import model.bean.Status;
import model.bean.TipoPessoa;

public class TestandoCliente {

    public static void main(String[] abc123) {
        IrradiacaoGlobalMes igm = IrradiacaoGlobalMesCTRL.BuscarPorId(11);
        Status sts = StatusCTRL.BuscaPorId(1);
        TipoPessoa tpPessoa = TipoPessoaCTRL.BuscaPorId(1);

        Cliente cliente = ClienteCTRL.BuscarPorId(0, 1, null);

//        List<Endereco> enderecos = new ArrayList<>();
//        enderecos.add(
//                new Endereco("Rua C165", "qd 363", "02", "74-275-170", Enumeradors.UF.GO, "Goiânia", igm, cliente)
//        );
//        cliente.setEnderecos(enderecos);
        List<Contato> contatos = new ArrayList<>();
        contatos.add(new Contato("951789654 telefone", cliente));
        cliente.setContatos(contatos);

        cliente.setIM("987654-0");
        System.out.println("====");
        System.out.println(ClienteCTRL.Gravar(cliente, null));
    }
}
