package questao9;

public class Pedido {

    private int numero;
    private double valor;

    public Pedido(int numero, double valor) {
        this.numero = numero;
        this.valor = valor;
    }

    public int getNumero() {
        return numero;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numero=" + numero +
                ", valor=" + valor +
                '}';
    }
}
