package tests;

import controller.ClienteCTRL;
import controller.EnderecoCTRL;
import model.bean.Cliente;
import model.bean.Endereco;
import view.DlgEnderecos;

public class TestandoEndereco {

    public static void main(String[] abc123) {
        Cliente c = ClienteCTRL.BuscarPorId(0, 16, null);
        Endereco e = EnderecoCTRL.BuscarPorID(10);
        e.setCliente(c);
        DlgEnderecos dlg = new DlgEnderecos(null, true, e);
        dlg.setVisible(true);
        dlg.toFront();

    }
}
