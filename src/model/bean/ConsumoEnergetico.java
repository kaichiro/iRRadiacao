package model.bean;

import utils.Enumeradors;

public class ConsumoEnergetico {

    private int id = 0;
    private double consumo = 0.00;
    private UnidadeConsumidora unidadeConsumidora;
    private String grupo = "";
    private double valorFatura = 0.0;
    private int mesReferencia = 0;
    private int anoReferencia = 0;
    private Enumeradors.TipoSaidaAC TipoLigacao = Enumeradors.TipoSaidaAC.Monofásico;

    public ConsumoEnergetico() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public UnidadeConsumidora getUnidadeConsumidora() {
        return unidadeConsumidora;
    }

    public void setUnidadeConsumidora(UnidadeConsumidora unidadeConsumidora) {
        this.unidadeConsumidora = unidadeConsumidora;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public double getValorFatura() {
        return valorFatura;
    }

    public void setValorFatura(double valorFatura) {
        this.valorFatura = valorFatura;
    }

    public int getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(int mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public int getAnoReferencia() {
        return anoReferencia;
    }

    public void setAnoReferencia(int anoReferencia) {
        this.anoReferencia = anoReferencia;
    }

    public Enumeradors.TipoSaidaAC getTipoLigacao() {
        return TipoLigacao;
    }

    public void setTipoLigacao(Enumeradors.TipoSaidaAC TipoLigacao) {
        this.TipoLigacao = TipoLigacao;
    }

    @Override
    public String toString() {
        return "ConsumoEnergetico{" + "id=" + id + ", consumo=" + consumo + ", grupo=" + grupo + ", valorFatura=" + valorFatura + ", mesReferencia=" + mesReferencia + ", anoReferencia=" + anoReferencia + ", TipoLigacao=" + TipoLigacao + ", UnidadeConsumidora:" + unidadeConsumidora.getId() + " }";
    }

    public boolean IsNew() {
        return this.id < 1;
    }
}
