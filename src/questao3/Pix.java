package questao3;

public class Pix extends Pagamento {

    private final String chavePix;

    public Pix(double valor, String chavePix) {
        super(valor);
        this.chavePix = chavePix;
    }

    @Override
    public double calcularTaxa() {
        return 0.0;
    }

    @Override
    public boolean validar() {
        return chavePix != null && !chavePix.isBlank();
    }
}
