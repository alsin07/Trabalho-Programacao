package Funcionarios;

public class Desenvolvedor extends Funcionario {

    private final int horasExtras;
    private final double valorHoraExtra;

    public Desenvolvedor(String nome, double salarioBase, int horasExtras, double valorHoraExtra) {
        super(nome, salarioBase);
        this.horasExtras = horasExtras;
        this.valorHoraExtra = valorHoraExtra;
    }

    @Override
    public double calcularRemuneracao() {
        return salarioBase + (horasExtras * valorHoraExtra);
    }
}
