package tests;

import model.bean.Status;
import controller.StatusCTRL;

public class TestandoStatus {

    public static void main(String[] abc) {
//        System.out.println("-----");
//        System.out.println("Criando Status ATIVO");
//        StatusCTRL.Novo("Ativo");
//
//        System.out.println("-----");
//        System.out.println("Criando Status INATIVO");
//        StatusCTRL.Novo("Inativo");

//        System.out.println("-----");
//        System.out.println("Buscando todos Status");
//        StatusCTRL.BuscaTodos().forEach((Status s) -> {
//            System.out.println(s.toString());
//        });
//        System.out.println("-----");
//        System.out.println("Pegando pelo ID: " + StatusCTRL.BuscaPorId(2).toString());
        System.out.println("-----");
        System.out.println("Atualizando primeiro registro");
        Status s = StatusCTRL.BuscaPorId(1);
        System.out.println("antes: " + s.toString());
        s.setDescricao(s.getDescricao().replace("=alter", ""));
        StatusCTRL.Atualiza(s);
        System.out.println("Pegando pelo ID (1) atualizado: " + StatusCTRL.BuscaPorId(1).toString());
    }
}
