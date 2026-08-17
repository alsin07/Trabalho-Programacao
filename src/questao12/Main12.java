package questao12;

public class Main12 {

    public static void main(String[] args) {

        try {

            Cliente cliente = new Cliente(
                    "Joao",
                    "joao@email.com",
                    22
            );

            String sql = GeradorSQL.gerarInsert(cliente);

            System.out.println("SQL gerado:");
            System.out.println(sql);

        } catch (Exception e) {

            System.out.println("Erro ao gerar SQL.");
            e.printStackTrace();

        }
    }
}