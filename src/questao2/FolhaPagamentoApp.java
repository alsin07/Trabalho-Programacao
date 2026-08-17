package questao2;

import java.util.List;

public class FolhaPagamentoApp {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = List.of(
                new Gerente("Ana Souza", 8000, 0.20),
                new Desenvolvedor("Bruno Lima", 6000, 10, 50),
                new Estagiario("Carla Melo", 1200, 300)
        );

        double totalFolha = 0;

        for (Funcionario f : funcionarios) {
            System.out.println(f);
            totalFolha += f.calcularRemuneracao();
        }

        System.out.printf("%nTotal da folha de pagamento: R$ %.2f%n", totalFolha);
    }
}
