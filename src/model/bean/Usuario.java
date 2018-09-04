package model.bean;

public class Usuario {

    private int id;
    private String login;
    private String senha;
    private Status status;
    private String nome;
    private PerfilGrupo perfilGrupo;

    public Usuario() {
    }

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(String login, String senha, Status status, String nome) {
        this.login = login;
        this.senha = senha;
        this.status = status;
        this.nome = nome;
    }

    public Usuario(int id, String login, String senha, Status status, String nome) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.status = status;
        this.nome = nome;
    }

    public Usuario(int id, String login, String senha, Status status, String nome, PerfilGrupo perfilGrupo) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.status = status;
        this.nome = nome;
        this.perfilGrupo = perfilGrupo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PerfilGrupo getPerfilGrupo() {
        return perfilGrupo;
    }

    public void setPerfilGrupo(PerfilGrupo perfilGrupo) {
        this.perfilGrupo = perfilGrupo;
    }

    public enum PerfilGrupo {
        Administrador, Engenheiro, Vendedor
    }

    public boolean IsNew() {
        return this.getId() <= 0;
    }

    @Override
    public String toString() {
//        return "Usuario{" + "id=" + id + ", login=" + login + ", senha=" + senha + ", status=" + status + ", nome=" + nome + '}';
        return id + " - " + login + " - " + nome;
    }

    public String asString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", senha=" + senha + ", status=" + status + ", nome=" + nome + ", perfilGrupo=" + perfilGrupo + '}';
    }

}
