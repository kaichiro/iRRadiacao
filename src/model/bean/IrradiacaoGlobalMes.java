package model.bean;

public class IrradiacaoGlobalMes {

    private int id;
    private double latitude;
    private double longitude;
    private double janeiro;
    private double fevereiro;
    private double marco;
    private double abril;
    private double maio;
    private double junho;
    private double julho;
    private double agosto;
    private double setembro;
    private double outubro;
    private double novembro;
    private double dezembro;
    private double anual;
    private double primavera;
    private double verao;
    private double outono;
    private double inverno;
    private int ano;

    public IrradiacaoGlobalMes() {
    }

    public IrradiacaoGlobalMes(int id) {
        this.id = id;
    }

    public IrradiacaoGlobalMes(double latitude, double longitude, double janeiro, double fevereiro, double marco, double abril, double maio, double junho, double julho, double agosto, double setembro, double outubro, double novembro, double dezembro, double anual, double primavera, double verao, double outono, double inverno, int ano) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.janeiro = janeiro;
        this.fevereiro = fevereiro;
        this.marco = marco;
        this.abril = abril;
        this.maio = maio;
        this.junho = junho;
        this.julho = julho;
        this.agosto = agosto;
        this.setembro = setembro;
        this.outubro = outubro;
        this.novembro = novembro;
        this.dezembro = dezembro;
        this.anual = anual;
        this.primavera = primavera;
        this.verao = verao;
        this.outono = outono;
        this.inverno = inverno;
        this.ano = ano;
    }

    public IrradiacaoGlobalMes(int id, double latitude, double longitude, double janeiro, double fevereiro, double marco, double abril, double maio, double junho, double julho, double agosto, double setembro, double outubro, double novembro, double dezembro, double anual, double primavera, double verao, double outono, double inverno, int ano) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.janeiro = janeiro;
        this.fevereiro = fevereiro;
        this.marco = marco;
        this.abril = abril;
        this.maio = maio;
        this.junho = junho;
        this.julho = julho;
        this.agosto = agosto;
        this.setembro = setembro;
        this.outubro = outubro;
        this.novembro = novembro;
        this.dezembro = dezembro;
        this.anual = anual;
        this.primavera = primavera;
        this.verao = verao;
        this.outono = outono;
        this.inverno = inverno;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getJaneiro() {
        return janeiro;
    }

    public void setJaneiro(double janeiro) {
        this.janeiro = janeiro;
    }

    public double getFevereiro() {
        return fevereiro;
    }

    public void setFevereiro(double fevereiro) {
        this.fevereiro = fevereiro;
    }

    public double getMarco() {
        return marco;
    }

    public void setMarco(double marco) {
        this.marco = marco;
    }

    public double getAbril() {
        return abril;
    }

    public void setAbril(double abril) {
        this.abril = abril;
    }

    public double getMaio() {
        return maio;
    }

    public void setMaio(double maio) {
        this.maio = maio;
    }

    public double getJunho() {
        return junho;
    }

    public void setJunho(double junho) {
        this.junho = junho;
    }

    public double getJulho() {
        return julho;
    }

    public void setJulho(double julho) {
        this.julho = julho;
    }

    public double getAgosto() {
        return agosto;
    }

    public void setAgosto(double agosto) {
        this.agosto = agosto;
    }

    public double getSetembro() {
        return setembro;
    }

    public void setSetembro(double setembro) {
        this.setembro = setembro;
    }

    public double getOutubro() {
        return outubro;
    }

    public void setOutubro(double outubro) {
        this.outubro = outubro;
    }

    public double getNovembro() {
        return novembro;
    }

    public void setNovembro(double novembro) {
        this.novembro = novembro;
    }

    public double getDezembro() {
        return dezembro;
    }

    public void setDezembro(double dezembro) {
        this.dezembro = dezembro;
    }

    public double getAnual() {
        return anual;
    }

    public void setAnual(double anual) {
        this.anual = anual;
    }

    public double getPrimavera() {
        return primavera;
    }

    public void setPrimavera(double primavera) {
        this.primavera = primavera;
    }

    public double getVerao() {
        return verao;
    }

    public void setVerao(double verao) {
        this.verao = verao;
    }

    public double getOutono() {
        return outono;
    }

    public void setOutono(double outono) {
        this.outono = outono;
    }

    public double getInverno() {
        return inverno;
    }

    public void setInverno(double inverno) {
        this.inverno = inverno;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
//        return "IrradiacaoGlobalMes{" + "id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", janeiro=" + janeiro + ", fevereiro=" + fevereiro + ", marco=" + marco + ", abril=" + abril + ", maio=" + maio + ", junho=" + junho + ", julho=" + julho + ", agosto=" + agosto + ", setembro=" + setembro + ", outubro=" + outubro + ", novembro=" + novembro + ", dezembro=" + dezembro + ", anual=" + anual + ", primavera=" + primavera + ", verao=" + verao + ", outono=" + outono + ", inverno=" + inverno + ", ano=" + ano + '}';
        return "la.=" + latitude + ", lo.=" + longitude + ", ano=" + ano;
    }

    public String asString() {
        return "Latitude=" + latitude + ", Longitude=" + longitude + ", Anual=" + anual
                + "\nJan=" + janeiro + ", Fev=" + fevereiro + ", Mar=" + marco + ", Abr=" + abril
                + "\nMai=" + maio + ", Jun=" + junho + ", Jul=" + julho + ", Ago=" + agosto
                + "\nSet=" + setembro + ", Out=" + outubro + ", Nov=" + novembro + ", Dez=" + dezembro
                + "\nPrimavera=" + primavera + ", Verao=" + verao + ", Outono=" + outono + ", Inverno=" + inverno;
    }

    public boolean IsNew() {
        return id < 1;
    }
}
