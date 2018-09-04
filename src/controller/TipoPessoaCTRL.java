package controller;

import java.util.List;
import model.bean.TipoPessoa;
import model.dao.TipoPessoaDAO;

public class TipoPessoaCTRL {

    public static List<TipoPessoa> BuscaTodos() {
        return new TipoPessoaDAO().GetAll();
    }

    public static TipoPessoa BuscaPorId(int i) {
        return new TipoPessoaDAO().GetById(i);
    }

    public static List<TipoPessoa> BuscaPorDescricao(String s) {
        return new TipoPessoaDAO().GetByDescricao(s);
    }

    public static void Novo(String descricao) {
        new TipoPessoaDAO().Insert(descricao);
    }

    public static void Atualiza(TipoPessoa s) {
        new TipoPessoaDAO().Update(s);
    }
}
