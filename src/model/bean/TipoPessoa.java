package model.bean;

public class TipoPessoa {

    private int id;
    private String descricao;

    public TipoPessoa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public TipoPessoa(String descricao) {
        this.descricao = descricao;
    }

    public TipoPessoa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

    public boolean IsNew() {
        return this.id < 1;
    }
}
