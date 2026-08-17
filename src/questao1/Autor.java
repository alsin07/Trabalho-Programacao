package questao1;

public class Autor {

    private final String nome;
    private final String nacionalidade;

    public Autor(String nome, String nacionalidade) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do autor não pode ser vazio.");
        }
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    @Override
    public String toString() {
        return nome + " (" + nacionalidade + ")";
    }
}
