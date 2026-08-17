package questao12;

@Tabela(nome = "clientes")
public class Cliente {

    @Coluna(nome = "nome")
    private String nome;

    @Coluna(nome = "email")
    private String email;

    private int idade;

    public Cliente(String nome, String email, int idade) {

        this.nome = nome;
        this.email = email;
        this.idade = idade;

    }
}