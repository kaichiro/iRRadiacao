package model.bean;

public class Contato {

    private int id;
    private String descricao;
    private Cliente cliente;

    public Contato() {
    }

    public Contato(int id) {
        this.id = id;
    }

    public Contato(String descricao, Cliente cliente) {
        this.descricao = descricao;
        this.cliente = cliente;
    }

    public Contato(int id, String descricao, Cliente cliente) {
        this.id = id;
        this.descricao = descricao;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", descricao=" + descricao + ", cliente=" + cliente + '}';
    }

    public boolean IsNew() {
        return this.id < 1;
    }
}
