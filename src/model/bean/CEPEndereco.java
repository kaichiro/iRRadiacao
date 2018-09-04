package model.bean;

import utils.Enumeradors;

public class CEPEndereco {

    private int id;
    private String CEP;
    private String logradouro;
    private String complemento;
    private String bairro;
    private Enumeradors.UF UF;
    private String cidade;
    private double latitude;
    private double longitude;

    public CEPEndereco() {
    }

    public CEPEndereco(int id, String CEP, String logradouro, String complemento, String bairro, Enumeradors.UF UF, String cidade, double latitude, double longitude) {
        this.id = id;
        this.CEP = CEP;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.UF = UF;
        this.cidade = cidade;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Enumeradors.UF getUF() {
        return UF;
    }

    public void setUF(Enumeradors.UF UF) {
        this.UF = UF;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    @Override
    public String toString() {
        return "CEPEndereco{" + "CEP=" + CEP + ", logradouro=" + logradouro + ", complemento=" + complemento + ", bairro=" + bairro + ", UF=" + UF + ", cidade=" + cidade + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }

}
