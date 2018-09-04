package model.bean;

public class ItemEntrada {

    private int id;
    private Inversor inversor;
    private Modulo modulo;
    private EntradaProduto entradaProduto;
    private int quantidade;
    private double valorUnitario;
    private double valorTotal_;

    public ItemEntrada() {
    }

    public ItemEntrada(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Inversor getInversor() {
        return inversor;
    }

    public void setInversor(Inversor inversor) {
        this.inversor = inversor;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public EntradaProduto getEntradaProduto() {
        return entradaProduto;
    }

    public void setEntradaProduto(EntradaProduto entradaProduto) {
        this.entradaProduto = entradaProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal_() {
        return valorTotal_;
    }

    public void setValorTotal_(double valorTotal_) {
        this.valorTotal_ = valorTotal_;
    }

//    @Override
//    public String toString() {
//        return "ItemEntrada{" + "id=" + id + ", inversor=" + inversor + ", modulo=" + modulo + ", entradaProduto=" + entradaProduto + ", quantidade=" + quantidade + ", valorUnitario=" + valorUnitario + ", valorTotal_=" + valorTotal_ + '}';
//    }

    @Override
    public String toString() {
        return "ItemEntrada{" + "id=" + id + ", inversor=" + inversor + ", modulo=" + modulo + ", quantidade=" + quantidade + ", valorUnitario=" + valorUnitario + ", valorTotal_=" + valorTotal_ + '}';
    }

    public boolean IsNew() {
        return this.getId() < 1;
    }
}
