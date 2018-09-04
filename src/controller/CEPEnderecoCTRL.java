package controller;

import java.util.List;
import model.bean.CEPEndereco;
import model.dao.CEPEnderecoDAO;

public class CEPEnderecoCTRL {

    public static List<CEPEndereco> BuscarPor_CEP_ou_Logradouro(int limit, String CEP_ou_Logradouro) {
        return new CEPEnderecoDAO().GetByCEP_or_Logradouro(limit, CEP_ou_Logradouro);
    }

    public static CEPEndereco BuscarPorId(int pId) {
        return new CEPEnderecoDAO().GetById(pId);
    }
}
