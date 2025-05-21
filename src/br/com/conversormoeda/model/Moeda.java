package main;

public class Moeda {
    private double conversion_rate;
    private double valorConvertido;
    private String base_code;
    private String target_code;

    public void setBaseAndTargetCode(String base_code, String target_code) {
        this.base_code = base_code;
        this.target_code = target_code;
    }

    public void setValorConvertido(double valor) {
        this.valorConvertido = conversion_rate * valor;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }
}
