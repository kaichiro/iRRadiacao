package model.bean;

import controller.IrradiacaoGlobalMesCTRL;
import java.util.List;
import utils.Enumeradors.UF;

public class Endereco {

    private int Id;
    private String Logradouro;
    private String Complemento;
    private String Numero;
    private String CEP;
    private UF UF;
    private String cidade;
    private IrradiacaoGlobalMes irradiacaoGlobalMes;
    private List<UnidadeConsumidora> unidadesConsumidoras;
    private Cliente cliente;
    private String bairro;
    private double latitude;
    private double longitude;

    public Endereco() {
    }

    public Endereco(int Id) {
        this.Id = Id;
    }

    public Endereco(int Id, Cliente cliente) {
        this.Id = Id;
        this.cliente = cliente;
    }

    public Endereco(String Logradouro, String Complemento, String Numero, String CEP, UF UF, String cidade, IrradiacaoGlobalMes irradiacaoGlobalMes, Cliente cliente) {
        this.Logradouro = Logradouro;
        this.Complemento = Complemento;
        this.Numero = Numero;
        this.CEP = CEP;
        this.UF = UF;
        this.cidade = cidade;
        this.irradiacaoGlobalMes = irradiacaoGlobalMes;
        this.cliente = cliente;
    }

    public Endereco(int Id, String Logradouro, String Complemento, String Numero, String CEP, UF UF, String cidade, IrradiacaoGlobalMes irradiacaoGlobalMes, Cliente cliente) {
        this.Id = Id;
        this.Logradouro = Logradouro;
        this.Complemento = Complemento;
        this.Numero = Numero;
        this.CEP = CEP;
        this.UF = UF;
        this.cidade = cidade;
        this.irradiacaoGlobalMes = irradiacaoGlobalMes;
        this.cliente = cliente;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String Logradouro) {
        this.Logradouro = Logradouro;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public UF getUF() {
        return UF;
    }

    public void setUF(UF UF) {
        this.UF = UF;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public IrradiacaoGlobalMes getIrradiacaoGlobalMes() {
        return irradiacaoGlobalMes;
    }

    public void setIrradiacaoGlobalMes(IrradiacaoGlobalMes irradiacaoGlobalMes) {
        this.irradiacaoGlobalMes = irradiacaoGlobalMes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<UnidadeConsumidora> getUnidadesConsumidoras() {
        return unidadesConsumidoras;
    }

    public void setUnidadesConsumidoras(List<UnidadeConsumidora> unidadesConsumidoras) {
        this.unidadesConsumidoras = unidadesConsumidoras;
    }

    public boolean IsNew() {
        return this.Id < 1;
    }

//    @Override
//    public String toString() {
//        return "Endereco{" + "Id=" + Id + ", Logradouro=" + Logradouro + ", Complemento=" + Complemento + ", Numero=" + Numero + ", CEP=" + CEP + ", UF=" + UF + ", cidade=" + cidade + ", irradiacaoGlobalMes=" + irradiacaoGlobalMes + ", unidadesConsumidoras=" + unidadesConsumidoras + ", cliente=" + cliente + '}';
//    }

    @Override
    public String toString() {
        return "Endereco{" + "Id=" + Id + ", Logradouro=" + Logradouro + ", Complemento=" + Complemento + ", Numero=" + Numero + ", CEP=" + CEP + ", UF=" + UF + ", cidade=" + cidade + ", irradiacaoGlobalMes=" + irradiacaoGlobalMes + ", unidadesConsumidoras=" + unidadesConsumidoras + ", cliente=" + cliente + ", bairro=" + bairro + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }

    public void Busca_IrradiacaoGlobalMes_byCoordenadas() {
        if (this.getLatitude() != 0 && this.getLongitude() != 0) {
            this.setIrradiacaoGlobalMes(IrradiacaoGlobalMesCTRL.BuscarPorCoordenadas(this.getLatitude(), this.getLongitude()));
        }
    }
}
