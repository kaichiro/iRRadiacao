package model.bean;

import utils.Enumeradors.UF;

public class Fornecedor {

    private int id;
    private String nomeFantasia;
    private String razaoSocial;
    private String CNPJ;
    private String IE;
    private String IM;
    private Status status;
    private String CEP;
    private String logradouro;
    private String complemento;
    private String enderecoNumero;
    private String bairro;
    private String cidade;
    private UF UF;
    private String fone;
    private String email;

    public Fornecedor() {
    }

    public Fornecedor(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getIE() {
        return IE;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

    public String getIM() {
        return IM;
    }

    public void setIM(String IM) {
        this.IM = IM;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UF getUF() {
        return UF;
    }

    public void setUF(UF UF) {
        this.UF = UF;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "id=" + id + ", nomeFantasia=" + nomeFantasia + ", razaoSocial=" + razaoSocial + ", CNPJ=" + CNPJ + ", IE=" + IE + ", IM=" + IM + ", status=" + status + ", CEP=" + CEP + ", logradouro=" + logradouro + ", complemento=" + complemento + ", enderecoNumero=" + enderecoNumero + ", bairro=" + bairro + ", cidade=" + cidade + ", UF=" + UF + ", fone=" + fone + ", email=" + email + '}';
    }

    public boolean IsNew() {
        return this.getId() <= 0;
    }

    public String AsString() {
        return (this.getRazaoSocial().trim().length() > 0 ? this.getRazaoSocial() : this.getNomeFantasia()) + "  " + this.getCNPJ();
    }

}
