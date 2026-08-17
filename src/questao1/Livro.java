package questao1;

public class Livro {

    private final String titulo;
    private final Autor autor;
    private final String isbn;
    private boolean disponivel;

    public Livro(String titulo, Autor autor, String isbn) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título não pode ser vazio.");
        }
        if (autor == null) {
            throw new IllegalArgumentException("Livro precisa ter um autor.");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    void marcarComoEmprestado() {
        if (!disponivel) {
            throw new IllegalStateException("Livro já está emprestado: " + titulo);
        }
        this.disponivel = false;
    }

    void marcarComoDevolvido() {
        this.disponivel = true;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + (disponivel ? " [disponível]" : " [emprestado]");
    }
}
