package questao1;

public class BibliotecaApp {

    public static void main(String[] args) {
        Autor machado = new Autor("Machado de Assis", "Brasileiro");
        Livro domCasmurro = new Livro("Dom Casmurro", machado, "978-85-000-0001");
        Livro memoriasPostumas = new Livro("Memórias Póstumas", machado, "978-85-000-0002");
        Livro quincasBorba = new Livro("Quincas Borba", machado, "978-85-000-0003");
        Livro esauEJaco = new Livro("Esaú e Jacó", machado, "978-85-000-0004");

        Usuario joao = new Usuario("João Silva", "U001");

        Emprestimo e1 = new Emprestimo(domCasmurro, joao);
        Emprestimo e2 = new Emprestimo(memoriasPostumas, joao);
        Emprestimo e3 = new Emprestimo(quincasBorba, joao);

        System.out.println(joao);
        System.out.println(domCasmurro);

        try {
            Emprestimo e4 = new Emprestimo(esauEJaco, joao);
        } catch (IllegalStateException ex) {
            System.out.println("Erro esperado: " + ex.getMessage());
        }

        e1.devolver();
        System.out.println("Depois da devolução: " + joao);
        System.out.println(domCasmurro);

        Emprestimo e4 = new Emprestimo(esauEJaco, joao);
        System.out.println("Novo empréstimo feito com sucesso: " + e4);
    }
}
