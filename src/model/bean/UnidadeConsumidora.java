package model.bean;

import java.util.List;
import utils.Enumeradors;

public class UnidadeConsumidora {

    private int id = 0;
    private String numero = "";
    private Enumeradors.TipoSaidaAC tipoDeLigacao = Enumeradors.TipoSaidaAC.Bifásico;
    private String numeroMedidor = "";
    private Endereco endereco;
    private List<ConsumoEnergetico> consumosEnergeticos;

    public UnidadeConsumidora() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Enumeradors.TipoSaidaAC getTipoDeLigacao() {
        return tipoDeLigacao;
    }

    public void setTipoDeLigacao(Enumeradors.TipoSaidaAC tipoDeLigacao) {
        this.tipoDeLigacao = tipoDeLigacao;
    }

    public String getNumeroMedidor() {
        return numeroMedidor;
    }

    public void setNumeroMedidor(String numeroMedidor) {
        this.numeroMedidor = numeroMedidor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<ConsumoEnergetico> getConsumosEnergeticos() {
        return consumosEnergeticos;
    }

    public void setConsumosEnergeticos(List<ConsumoEnergetico> consumosEnergeticos) {
        this.consumosEnergeticos = consumosEnergeticos;
    }

    @Override
    public String toString() {
        return "UnidadeConsumidora{" + "id=" + id + ", numero=" + numero + ", tipoDeLigacao=" + tipoDeLigacao + ", numeroMedidor=" + numeroMedidor + ", endereco=" + endereco + ", consumosEnergeticos=" + consumosEnergeticos + '}';
    }

    public boolean IsNew() {
        return this.id < 1;
    }

}
