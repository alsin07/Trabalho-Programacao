package questao2;

public abstract class Funcionario {

    protected final String nome;
    protected final double salarioBase;

    protected Funcionario(String nome, double salarioBase) {
        if (salarioBase < 0) {
            throw new IllegalArgumentException("Salário base não pode ser negativo.");
        }
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public abstract double calcularRemuneracao();

    @Override
    public String toString() {
        return String.format("%-12s %-20s R$ %.2f",
                getClass().getSimpleName(), nome, calcularRemuneracao());
    }
}
