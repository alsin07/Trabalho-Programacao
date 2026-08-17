package questao2;

public class Gerente extends Funcionario {

    private final double percentualBonus;

    public Gerente(String nome, double salarioBase, double percentualBonus) {
        super(nome, salarioBase);
        this.percentualBonus = percentualBonus;
    }

    @Override
    public double calcularRemuneracao() {
        return salarioBase + (salarioBase * percentualBonus);
    }
}
