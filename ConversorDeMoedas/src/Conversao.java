public class Conversao {

    private double valorOriginal;
    private double valorConvertido;
    private String moedaOrigem;
    private String moedaDestino;

    public Conversao(double valorOriginal, double valorConvertido, String moedaOrigem, String moedaDestino) {
        this.valorOriginal = valorOriginal;
        this.valorConvertido = valorConvertido;
        this.moedaOrigem = moedaOrigem;
        this.moedaDestino = moedaDestino;
    }

    public double getValorOriginal() {
        return valorOriginal;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    public String getMoedaOrigem() {
        return moedaOrigem;
    }

    public String getMoedaDestino() {
        return moedaDestino;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s equivale a %.2f %s", valorOriginal, moedaOrigem, valorConvertido, moedaDestino);
    }
}
