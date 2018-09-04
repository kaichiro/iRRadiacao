package model.bean;

public class Status {

    private int id;
    private String descricao;

    public Status() {
    }

    public Status(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
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

    public boolean IsNew() {
        return this.id > 0;
    }

    @Override
    public String toString() {
        return descricao;
    }

}
