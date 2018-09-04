package model.bean;

public class Modulo {

    private int id;
    private String descricao;
    private String modelo;
    private int PMaxWp;
    private double UocV;
    private int alturaMM;
    private int larguraMM;
    private int espessuraMM;
    private double eficiencia;
    private double superficieMM2;
    private Status status;
    private double valorVenda;
    private int saldo;

    public Modulo() {
    }

    public Modulo(int id) {
        this.id = id;
    }

    /**
     * Novo obj
     */
    public Modulo(String descricao, String modelo, int PMaxWp, double UocV, int alturaMM, int larguraMM, int espessuraMM, Status status, double valorVenda) {
        this.descricao = descricao;
        this.modelo = modelo;
        this.PMaxWp = PMaxWp;
        this.UocV = UocV;
        this.alturaMM = alturaMM;
        this.larguraMM = larguraMM;
        this.espessuraMM = espessuraMM;
        this.status = status;
        this.valorVenda = valorVenda;
    }

    public Modulo(String descricao, String Modelo, int PMaxWp, double UocV, int AlturaMM, int LarguraMM, int EspessuraMM, double Eficiencia, double SuperficieMM2, Status status, double ValorVenda) {
        this.descricao = descricao;
        this.modelo = Modelo;
        this.PMaxWp = PMaxWp;
        this.UocV = UocV;
        this.alturaMM = AlturaMM;
        this.larguraMM = LarguraMM;
        this.espessuraMM = EspessuraMM;
        this.eficiencia = Eficiencia;
        this.superficieMM2 = SuperficieMM2;
        this.status = status;
        this.valorVenda = ValorVenda;
    }

    public Modulo(int id, String descricao, String Modelo, int PMaxWp, double UocV, int AlturaMM, int LarguraMM, int EspessuraMM, double Eficiencia, double SuperficieMM2, Status status, double ValorVenda) {
        this.id = id;
        this.descricao = descricao;
        this.modelo = Modelo;
        this.PMaxWp = PMaxWp;
        this.UocV = UocV;
        this.alturaMM = AlturaMM;
        this.larguraMM = LarguraMM;
        this.espessuraMM = EspessuraMM;
        this.eficiencia = Eficiencia;
        this.superficieMM2 = SuperficieMM2;
        this.status = status;
        this.valorVenda = ValorVenda;
    }

    public Modulo(int id, String descricao, String modelo, int PMaxWp, double UocV, int alturaMM, int larguraMM, int espessuraMM, double eficiencia, double superficieMM2, Status status, double valorVenda, int saldo) {
        this.id = id;
        this.descricao = descricao;
        this.modelo = modelo;
        this.PMaxWp = PMaxWp;
        this.UocV = UocV;
        this.alturaMM = alturaMM;
        this.larguraMM = larguraMM;
        this.espessuraMM = espessuraMM;
        this.eficiencia = eficiencia;
        this.superficieMM2 = superficieMM2;
        this.status = status;
        this.valorVenda = valorVenda;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPMaxWp() {
        return PMaxWp;
    }

    public void setPMaxWp(int PMaxWp) {
        this.PMaxWp = PMaxWp;
    }

    public double getUocV() {
        return UocV;
    }

    public void setUocV(double UocV) {
        this.UocV = UocV;
    }

    public int getAlturaMM() {
        return alturaMM;
    }

    public void setAlturaMM(int alturaMM) {
        this.alturaMM = alturaMM;
    }

    public int getLarguraMM() {
        return larguraMM;
    }

    public void setLarguraMM(int larguraMM) {
        this.larguraMM = larguraMM;
    }

    public int getEspessuraMM() {
        return espessuraMM;
    }

    public void setEspessuraMM(int espessuraMM) {
        this.espessuraMM = espessuraMM;
    }

    public double getEficiencia() {
        return eficiencia;
    }

    private void setEficiencia(double eficiencia) {
        this.eficiencia = eficiencia;
    }

    public double getSuperficieMM2() {
        return superficieMM2;
    }

    private void setSuperficieMM2(double superficieMM2) {
        this.superficieMM2 = superficieMM2;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

//    @Override
//    public String toString() {
////        return "Modulo{" + "id=" + id + ", descricao=" + descricao + ", modelo=" + modelo + ", PMaxWp=" + PMaxWp + ", UocV=" + UocV + ", alturaMM=" + alturaMM + ", larguraMM=" + larguraMM + ", espessuraMM=" + espessuraMM + ", eficiencia=" + eficiencia + ", superficieMM2=" + superficieMM2 + ", status=" + status + ", valorVenda=" + valorVenda + '}';
//        return id + "-" + descricao;
//    }
    @Override
    public String toString() {
        return "Modulo{" + "id=" + id + ", descricao=" + descricao + ", modelo=" + modelo + ", PMaxWp=" + PMaxWp + ", UocV=" + UocV + ", alturaMM=" + alturaMM + ", larguraMM=" + larguraMM + ", espessuraMM=" + espessuraMM + ", eficiencia=" + eficiencia + ", superficieMM2=" + superficieMM2 + ", status=" + status + ", valorVenda=" + valorVenda + '}';
    }

    public boolean IsNew() {
        return this.getId() < 1;
    }
}
