package questao3;

import java.util.List;

public class PagamentoApp {

    public static void main(String[] args) {
        List<Pagamento> pagamentos = List.of(
                new CartaoCredito(250.00, "1234567812345678", 3),
                new Pix(120.00, "usuario@banco.com"),
                new Boleto(500.00, "01234567890123456789012345678901234567890123456")
        );

        for (Pagamento p : pagamentos) {
            p.processar();
        }
    }
}
