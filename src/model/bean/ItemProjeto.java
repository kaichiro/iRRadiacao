package model.bean;

public class ItemProjeto {

    private int id;
    private Projeto projeto;
    private Modulo modulo;
    private Inversor inversor;
    private double valorUnitario;
    private double valorTotal;
    private int quantidade;

    public ItemProjeto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Inversor getInversor() {
        return inversor;
    }

    public void setInversor(Inversor inversor) {
        this.inversor = inversor;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemProjeto{" + "id=" + id + ", projeto=" + projeto + ", modulo=" + modulo + ", inversor=" + inversor + ", valorUnitario=" + valorUnitario + ", quantidade=" + quantidade + '}';
    }

    public String asString() {
        return "ID: " + id + " " + (modulo != null ? ", Modulo" : "") + (inversor != null ? ", Inversor" : "") + ", qtde: " + quantidade;
    }

    public boolean IsNew() {
        return this.id < 1;
    }
}
