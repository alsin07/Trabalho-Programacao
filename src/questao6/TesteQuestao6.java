package questao6;

public class TesteQuestao6  {
    public static void main(String[] args) {
        Repositorio<Cliente> repoCliente = new Repositorio<>();
        Cliente c1 = new Cliente(1, "caio");
        repoCliente.salvar(c1);

        System.out.println("clientes cadastrados: " + repoCliente.listarTodos());

        Repositorio<Produto> repoProduto = new Repositorio<>();
        Produto p1 = new Produto(101, "mouse gamer");
        repoProduto.salvar(p1);

        System.out.println("produtos cadastrados: " + repoProduto.listarTodos());

        System.out.println("detalhes do produto: ");
        Repositorio.exibirDetalhes(p1);

        boolean iguais = Repositorio.saoIguais(c1, c1);
        System.out.println("objetos são iguais? " + iguais);
    }
}