package questao1;

import java.time.LocalDate;

public class Emprestimo {

    private final Livro livro;
    private final Usuario usuario;
    private final LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean ativo;

    public Emprestimo(Livro livro, Usuario usuario) {
        if (livro == null || usuario == null) {
            throw new IllegalArgumentException("Livro e usuário são obrigatórios.");
        }
        if (!livro.isDisponivel()) {
            throw new IllegalStateException("Livro indisponível: " + livro.getTitulo());
        }
        if (!usuario.podePegarEmprestimo()) {
            throw new IllegalStateException("Usuário atingiu o limite de empréstimos: " + usuario.getNome());
        }

        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.ativo = true;

        livro.marcarComoEmprestado();
        usuario.adicionarEmprestimo(this);
    }

    public void devolver() {
        if (!ativo) {
            throw new IllegalStateException("Este empréstimo já foi finalizado.");
        }
        this.ativo = false;
        this.dataDevolucao = LocalDate.now();
        livro.marcarComoDevolvido();
        usuario.removerEmprestimo(this);
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    @Override
    public String toString() {
        return "Empréstimo{" + livro.getTitulo() + " -> " + usuario.getNome() +
                ", desde " + dataEmprestimo + ", ativo=" + ativo + "}";
    }
}
