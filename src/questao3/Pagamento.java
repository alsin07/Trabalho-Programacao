package questao3;

public abstract class Pagamento implements Processavel, Validavel {

    protected final double valor;

    protected Pagamento(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do pagamento deve ser positivo.");
        }
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public abstract double calcularTaxa();

    public double getValorTotal() {
        return valor + calcularTaxa();
    }

    @Override
    public void processar() {
        if (!validar()) {
            throw new IllegalStateException("Pagamento inválido: " + getClass().getSimpleName());
        }
        System.out.printf("[%s] valor=R$ %.2f taxa=R$ %.2f total=R$ %.2f -> processado com sucesso%n",
                getClass().getSimpleName(), valor, calcularTaxa(), getValorTotal());
    }
}
