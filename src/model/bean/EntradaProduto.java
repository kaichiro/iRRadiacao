package model.bean;

import java.util.Date;
import java.util.List;

public class EntradaProduto {

    private int id;
    private Date data;
    private double descontos;
    private double valorProdutos_;
    private double valorLiquido_;
    private Fornecedor fornecedor;
    private List<ItemEntrada> itens;

    public EntradaProduto() {
    }

    public EntradaProduto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getDescontos() {
        return descontos;
    }

    public void setDescontos(double descontos) {
        this.descontos = descontos;
    }

    public double getValorProdutos_() {
        return valorProdutos_;
    }

    public void setValorProdutos_(double valorProdutos_) {
        this.valorProdutos_ = valorProdutos_;
    }

    public double getValorLiquido_() {
        return valorLiquido_;
    }

    public void setValorLiquido_(double valorLiquido_) {
        this.valorLiquido_ = valorLiquido_;
    }

    public List<ItemEntrada> getItens() {
        return itens;
    }

    public void setItens(List<ItemEntrada> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "EntradaProduto{" + "id=" + id + ", data=" + data + ", descontos=" + descontos + ", valorProdutos_=" + valorProdutos_ + ", valorLiquido_=" + valorLiquido_ + "\n, fornecedor=" + fornecedor + "\n, itens=" + itens + '}';
    }

    public boolean IsNew() {
        return this.getId() < 1;
    }
}
