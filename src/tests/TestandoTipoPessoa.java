package tests;

import controller.TipoPessoaCTRL;
import model.bean.TipoPessoa;

public class TestandoTipoPessoa {

    public static void main(String[] abc132) {
        TipoPessoaCTRL.BuscaTodos().forEach((TipoPessoa tp) -> {
            System.out.println(tp.toString());
        });
    }
}
