package Funcionarios;

public class Estagiario extends Funcionario {

    private final double auxilioTransporte;

    public Estagiario(String nome, double bolsa, double auxilioTransporte) {
        super(nome, bolsa);
        this.auxilioTransporte = auxilioTransporte;
    }

    @Override
    public double calcularRemuneracao() {
        return salarioBase + auxilioTransporte;
    }
}
