package model.bean;

import java.util.Date;
import java.util.List;

public class Cliente {

    private int id = 0;
    private String nomeFantasia_Apelido = "";
    private String razaoSocial_Nome = "";
    private String CNPJ_CPF = "";
    private String IE_RG = "";
    private String IM = "";
    private Date dataNascimento;
    private Status status;
    private TipoPessoa tipoPessoa;
    private List<Endereco> enderecos;
    private List<Contato> contatos;

    public Cliente() {
    }

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(String nomeFantasia_Apelido, String razaoSocial_Nome, String CNPJ_CPF, String IE_RG, String IM, Date dataNascimento, Status status, TipoPessoa tipoPessoa, List<Endereco> enderecos, List<Contato> contatos) {
        this.nomeFantasia_Apelido = nomeFantasia_Apelido;
        this.razaoSocial_Nome = razaoSocial_Nome;
        this.CNPJ_CPF = CNPJ_CPF;
        this.IE_RG = IE_RG;
        this.IM = IM;
        this.dataNascimento = dataNascimento;
        this.status = status;
        this.tipoPessoa = tipoPessoa;
        this.enderecos = enderecos;
        this.contatos = contatos;
    }

    /**
     * Tipo Jurídico
     */
    public Cliente(String nomeFantasia_Apelido, String razaoSocial_Nome, String CNPJ_CPF, String IE_RG, String IM, Status status, TipoPessoa tipoPessoa) {
        this.nomeFantasia_Apelido = nomeFantasia_Apelido;
        this.razaoSocial_Nome = razaoSocial_Nome;
        this.CNPJ_CPF = CNPJ_CPF;
        this.IE_RG = IE_RG;
        this.IM = IM;
        this.status = status;
        this.tipoPessoa = tipoPessoa;
    }

    /**
     * Tipo Físico
     */
    public Cliente(String nomeFantasia_Apelido, String razaoSocial_Nome, String CNPJ_CPF, String IE_RG, String IM, Date dataNascimento, Status status, TipoPessoa tipoPessoa) {
        this.nomeFantasia_Apelido = nomeFantasia_Apelido;
        this.razaoSocial_Nome = razaoSocial_Nome;
        this.CNPJ_CPF = CNPJ_CPF;
        this.IE_RG = IE_RG;
        this.IM = IM;
        this.dataNascimento = dataNascimento;
        this.status = status;
        this.tipoPessoa = tipoPessoa;
    }

    public Cliente(int id, String nomeFantasia_Apelido, String razaoSocial_Nome, String CNPJ_CPF, String IE_RG, String IM, Date dataNascimento, Status status, TipoPessoa tipoPessoa, List<Endereco> enderecos, List<Contato> contatos) {
        this.id = id;
        this.nomeFantasia_Apelido = nomeFantasia_Apelido;
        this.razaoSocial_Nome = razaoSocial_Nome;
        this.CNPJ_CPF = CNPJ_CPF;
        this.IE_RG = IE_RG;
        this.IM = IM;
        this.dataNascimento = dataNascimento;
        this.status = status;
        this.tipoPessoa = tipoPessoa;
        this.enderecos = enderecos;
        this.contatos = contatos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFantasia_Apelido() {
        return nomeFantasia_Apelido;
    }

    public void setNomeFantasia_Apelido(String nomeFantasia_Apelido) {
        this.nomeFantasia_Apelido = nomeFantasia_Apelido;
    }

    public String getRazaoSocial_Nome() {
        return razaoSocial_Nome;
    }

    public void setRazaoSocial_Nome(String razaoSocial_Nome) {
        this.razaoSocial_Nome = razaoSocial_Nome;
    }

    public String getCNPJ_CPF() {
        return CNPJ_CPF;
    }

    public void setCNPJ_CPF(String CNPJ_CPF) {
        this.CNPJ_CPF = CNPJ_CPF;
    }

    public String getIE_RG() {
        return IE_RG;
    }

    public void setIE_RG(String IE_RG) {
        this.IE_RG = IE_RG;
    }

    public String getIM() {
        return IM;
    }

    public void setIM(String IM) {
        this.IM = IM;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public boolean IsNew() {
        return this.id < 1;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

//    public boolean IsCPF_CNPJ_Valid() {
//        String CPF_CNPJ = "";
//
//        for (int i = 0; i < this.getCNPJ_CPF().length(); i++) {
//            for (int j = 0; j < 10; j++) {
//                if (this.getCNPJ_CPF().substring(i, 1) == null
//                        ? String.valueOf(j) == null
//                        : this.getCNPJ_CPF().substring(i, 1).equals(String.valueOf(j))) {
//                    CPF_CNPJ += this.getCNPJ_CPF().substring(i, 1);
//                }
//            }
//        }
//
//        if (this.getStatus() != null) {
//            if (this.getStatus().getDescricao().endsWith("sica")) {
//                return Validacao_CNPJ_CPF.isValidoCPF(CPF_CNPJ);
//            } else {
//                return Validacao_CNPJ_CPF.isValidCNPJ(CPF_CNPJ);
//            }
//        } else {
//            return false;
//        }
//    }
    @Override
    public String toString() {
        return id + "-" + CNPJ_CPF + " - " + razaoSocial_Nome + " - " + nomeFantasia_Apelido;
    }

    public String asString() {
        return "Cliente{" + "id=" + id + ", nomeFantasia_Apelido=" + nomeFantasia_Apelido + ", razaoSocial_Nome=" + razaoSocial_Nome + ", CNPJ_CPF=" + CNPJ_CPF + ", IE_RG=" + IE_RG + ", IM=" + IM + ", dataNascimento=" + dataNascimento + ", status=" + status + ", tipoPessoa=" + tipoPessoa + ", enderecos=" + enderecos + ", contatos=" + contatos + '}';
    }

}
