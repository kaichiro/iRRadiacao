package model.bean;

public class NecessidadeEnergeticaCliente {

    private Cliente cliente;
    private double totalConsumo;
    private double qtdeConsumo;
    private double irradiacaoDoLocal;
    private double mediaConsumoMes;
    private double mediaConsumoDia;
    private double calc1;
    private double calc2;

    public NecessidadeEnergeticaCliente(Cliente cliente, double totalConsumo, double qtdeConsumo, double irradiacaoDoLocal) {
        this.cliente = cliente;
        this.totalConsumo = totalConsumo;
        this.qtdeConsumo = qtdeConsumo;
        this.irradiacaoDoLocal = irradiacaoDoLocal;
        this.mediaConsumoMes = (this.totalConsumo / this.qtdeConsumo) * 100;
        this.mediaConsumoDia = this.mediaConsumoMes / 30;
        this.calc1 = mediaConsumoDia / this.irradiacaoDoLocal;
        this.calc2 = calc1 * 0.8;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotalConsumo() {
        return totalConsumo;
    }

    public double getQtdeConsumo() {
        return qtdeConsumo;
    }

    public double getIrradiacaoDoLocal() {
        return irradiacaoDoLocal;
    }

    public double getMediaConsumoMes() {
        return mediaConsumoMes;
    }

    public double getMediaConsumoDia() {
        return mediaConsumoDia;
    }

    public double getCalc1() {
        return calc1;
    }

    public double getCalc2() {
        return calc2;
    }

    @Override
    public String toString() {
        return "NecessidadeEneregeticaCliente{" + "cliente=" + cliente + ", totalConsumo=" + totalConsumo + ", qtdeConsumo=" + qtdeConsumo + ", irradiacaoDoLocal=" + irradiacaoDoLocal + ", mediaConsumoMes=" + mediaConsumoMes + ", mediaConsumoDia=" + mediaConsumoDia + ", calc1=" + calc1 + ", calc2=" + this.getCalc2() + '}';
    }

    public String asString() {
        return ""
                + String.format("Total Consumo: %.2f", totalConsumo)
                + String.format("   Quantidade Meses: %.2f", qtdeConsumo)
                + String.format("   Irradiação: %.2f", irradiacaoDoLocal)
                + String.format("   Média Consumo Dia: %.2f", mediaConsumoDia)
                + String.format("   Consumo Satisfatório: %.2f", calc2)
                + "";
    }
}
