package questao3;

public class CartaoCredito extends Pagamento {

    private static final double TAXA_PERCENTUAL = 0.035;

    private final String numeroCartao;
    private final int parcelas;

    public CartaoCredito(double valor, String numeroCartao, int parcelas) {
        super(valor);
        this.numeroCartao = numeroCartao;
        this.parcelas = parcelas;
    }

    @Override
    public double calcularTaxa() {
        return valor * TAXA_PERCENTUAL;
    }

    @Override
    public boolean validar() {
        return numeroCartao != null && numeroCartao.replaceAll("\\D", "").length() == 16
                && parcelas >= 1;
    }
}