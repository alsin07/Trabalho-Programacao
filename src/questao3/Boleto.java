package questao3;

public class Boleto extends Pagamento {

    private static final double TAXA_FIXA = 3.50;

    private final String codigoBarras;

    public Boleto(double valor, String codigoBarras) {
        super(valor);
        this.codigoBarras = codigoBarras;
    }

    @Override
    public double calcularTaxa() {
        return TAXA_FIXA;
    }

    @Override
    public boolean validar() {
        return codigoBarras != null && codigoBarras.length() == 47;
    }
}
