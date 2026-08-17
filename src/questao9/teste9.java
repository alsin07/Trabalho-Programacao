package questao9;

import java.util.List;

public class teste9 {

    public static void main(String[] args) {

        Cliente cliente = new Cliente(
                "",
                "email-invalido",
                15
        );


        Validador<Cliente> validadorCliente =
                new Validador<>();


        validadorCliente
                .adicionarRegra(c ->
                        c.getNome() == null ||
                                c.getNome().isBlank()
                                ? "Nome não pode ser vazio"
                                : null
                )

                .adicionarRegra(c ->
                        c.getEmail() == null ||
                                !c.getEmail().contains("@")
                                ? "E-mail inválido"
                                : null
                )

                .adicionarRegra(c ->
                        c.getIdade() < 18
                                ? "Cliente deve ser maior de idade"
                                : null
                );


        List<String> erros =
                validadorCliente.validar(cliente);


        System.out.println("=== VALIDAÇÃO DO CLIENTE ===");

        if (erros.isEmpty()) {

            System.out.println("Cliente válido.");

        } else {

            System.out.println("Erros encontrados:");

            for (String erro : erros) {
                System.out.println("- " + erro);
            }
        }
    }
}