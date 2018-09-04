package model.bean;

import java.sql.Date;
import java.util.List;

public class Projeto {

    private int id;
    private Date dataCadastro;
    private Date dataUltimaAlteracao;
    private Cliente cliente;
    private Status status;
    private double Desconto = 0;
    private double Acrescimo = 0;
    private double totalProdutos = 0;
    private double totalLiquido = 0;
    private Date PrevisaoEntrega;
    private Date Conclusao;
    private List<ItemProjeto> itens;
    private List<UnidadeConsumidora> unidadesConsumidoras;

    public Projeto() {
    }

    public Projeto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getDesconto() {
        return Desconto;
    }

    public void setDesconto(double Desconto) {
        this.Desconto = Desconto;
//        this.ProcessaValores();
    }

    public double getAcrescimo() {
        return Acrescimo;
    }

    public void setAcrescimo(double Acrescimo) {
        this.Acrescimo = Acrescimo;
//        this.ProcessaValores();
    }

    public Date getPrevisaoEntrega() {
        return PrevisaoEntrega;
    }

    public void setPrevisaoEntrega(Date PrevisaoEntrega) {
        this.PrevisaoEntrega = PrevisaoEntrega;
    }

    public Date getConclusao() {
        return Conclusao;
    }

    public void setConclusao(Date Conclusao) {
        this.Conclusao = Conclusao;
    }

    public boolean IsNew() {
        return this.id < 1;
    }

    public List<ItemProjeto> getItens() {
        return itens;
    }

    public void setItens(List<ItemProjeto> itens) {
        this.itens = itens;
//        this.ProcessaValores();
    }

    public List<UnidadeConsumidora> getUnidadesConsumidoras() {
        return unidadesConsumidoras;
    }

    public void setUnidadesConsumidoras(List<UnidadeConsumidora> unidadesConsumidoras) {
        this.unidadesConsumidoras = unidadesConsumidoras;
    }

    public double getTotalProdutos() {
        return totalProdutos;
    }

    public double getTotalLiquido() {
        return totalLiquido;
    }

    public void setTotalProdutos(double totalProdutos) {
        this.totalProdutos = totalProdutos;
    }

    public void setTotalLiquido(double totalLiquido) {
        this.totalLiquido = totalLiquido;
    }

//    private void ProcessaValores() {
//        double vlrTotProds = 0;
//        if (!(this.getItens()==null)) {
//            for (ItemProjeto ip : this.getItens()) {
//                vlrTotProds += ip.getValorTotal();
//            }
//        }
//        this.setTotalProdutos(vlrTotProds);
//
//        this.setTotalLiquido(this.getTotalProdutos() + this.getAcrescimo() - this.getDesconto());
//    }

    @Override
    public String toString() {
        return "Projeto{" + "id=" + id + ", dataCadastro=" + dataCadastro + ", dataUltimaAlteracao=" + dataUltimaAlteracao + ", cliente=" + cliente + ", status=" + status + ", Desconto=" + Desconto + ", Acrescimo=" + Acrescimo + ", PrevisaoEntrega=" + PrevisaoEntrega + ", Conclusao=" + Conclusao + '}';
    }

}
