package model.bean;

import utils.Enumeradors.TipoSaidaAC;

public class Inversor {

    private int id;
    private Status status;
    private String modelo;
    private int potenciaWCA;
    private int potenciaMaxWCC;
    private double iccMaxEntradaA;
    private double uccMaxEntradaA;
    private double rendimentoNacional;
    private double rendimentoMaximo;
    private TipoSaidaAC tipoSaidaAC;
    private double valorVenda;
    private int saldo;

    public Inversor() {
    }

    public Inversor(int id) {
        this.id = id;
    }

    public Inversor(Status status, String modelo, int potenciaWCA, int potenciaMaxWCC, double iccMaxEntradaA, double uccMaxEntradaA, double rendimentoNacional, double rendimentoMaximo, TipoSaidaAC tipoSaidaAC, double valorVenda) {
        this.status = status;
        this.modelo = modelo;
        this.potenciaWCA = potenciaWCA;
        this.potenciaMaxWCC = potenciaMaxWCC;
        this.iccMaxEntradaA = iccMaxEntradaA;
        this.uccMaxEntradaA = uccMaxEntradaA;
        this.rendimentoNacional = rendimentoNacional;
        this.rendimentoMaximo = rendimentoMaximo;
        this.tipoSaidaAC = tipoSaidaAC;
        this.valorVenda = valorVenda;
    }

    public Inversor(int id, Status status, String modelo, int potenciaWCA, int potenciaMaxWCC, double iccMaxEntradaA, double uccMaxEntradaA, double rendimentoNacional, double rendimentoMaximo, TipoSaidaAC tipoSaidaAC, double valorVenda) {
        this.id = id;
        this.status = status;
        this.modelo = modelo;
        this.potenciaWCA = potenciaWCA;
        this.potenciaMaxWCC = potenciaMaxWCC;
        this.iccMaxEntradaA = iccMaxEntradaA;
        this.uccMaxEntradaA = uccMaxEntradaA;
        this.rendimentoNacional = rendimentoNacional;
        this.rendimentoMaximo = rendimentoMaximo;
        this.tipoSaidaAC = tipoSaidaAC;
        this.valorVenda = valorVenda;
    }

    public Inversor(int id, Status status, String modelo, int potenciaWCA, int potenciaMaxWCC, double iccMaxEntradaA, double uccMaxEntradaA, double rendimentoNacional, double rendimentoMaximo, TipoSaidaAC tipoSaidaAC, double valorVenda, int saldo) {
        this.id = id;
        this.status = status;
        this.modelo = modelo;
        this.potenciaWCA = potenciaWCA;
        this.potenciaMaxWCC = potenciaMaxWCC;
        this.iccMaxEntradaA = iccMaxEntradaA;
        this.uccMaxEntradaA = uccMaxEntradaA;
        this.rendimentoNacional = rendimentoNacional;
        this.rendimentoMaximo = rendimentoMaximo;
        this.tipoSaidaAC = tipoSaidaAC;
        this.valorVenda = valorVenda;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPotenciaWCA() {
        return potenciaWCA;
    }

    public void setPotenciaWCA(int potenciaWCA) {
        this.potenciaWCA = potenciaWCA;
    }

    public int getPotenciaMaxWCC() {
        return potenciaMaxWCC;
    }

    public void setPotenciaMaxWCC(int potenciaMaxWCC) {
        this.potenciaMaxWCC = potenciaMaxWCC;
    }

    public double getIccMaxEntradaA() {
        return iccMaxEntradaA;
    }

    public void setIccMaxEntradaA(double iccMaxEntradaA) {
        this.iccMaxEntradaA = iccMaxEntradaA;
    }

    public double getUccMaxEntradaA() {
        return uccMaxEntradaA;
    }

    public void setUccMaxEntradaA(double uccMaxEntradaA) {
        this.uccMaxEntradaA = uccMaxEntradaA;
    }

    public double getRendimentoNacional() {
        return rendimentoNacional;
    }

    public void setRendimentoNacional(double rendimentoNacional) {
        this.rendimentoNacional = rendimentoNacional;
    }

    public double getRendimentoMaximo() {
        return rendimentoMaximo;
    }

    public void setRendimentoMaximo(double rendimentoMaximo) {
        this.rendimentoMaximo = rendimentoMaximo;
    }

    public TipoSaidaAC getTipoSaidaAC() {
        return tipoSaidaAC;
    }

    public void setTipoSaidaAC(TipoSaidaAC tipoSaidaAC) {
        this.tipoSaidaAC = tipoSaidaAC;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public static TipoSaidaAC PegaTipoSaidaAC_porTexto(String TipoSaida) {
        return TipoSaidaAC.Monofásico.toString().equals(TipoSaida) ? TipoSaidaAC.Monofásico
                : TipoSaidaAC.Bifásico.toString().equals(TipoSaida) ? TipoSaidaAC.Bifásico
                : TipoSaidaAC.Trifásico;
    }

    public boolean IsNew() {
        return this.getId() < 1;
    }

    @Override
    public String toString() {
        return "Inversor{" + "id=" + id + ", status=" + status + ", modelo=" + modelo + ", potenciaWCA=" + potenciaWCA + ", potenciaMaxWCC=" + potenciaMaxWCC + ", iccMaxEntradaA=" + iccMaxEntradaA + ", uccMaxEntradaA=" + uccMaxEntradaA + ", rendimentoNacional=" + rendimentoNacional + ", rendimentoMaximo=" + rendimentoMaximo + ", tipoSaidaAC=" + tipoSaidaAC + ", valorVenda=" + valorVenda + ", saldo=" + saldo + '}';
    }


}
