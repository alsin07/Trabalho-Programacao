package Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private static final int LIMITE_EMPRESTIMOS_ATIVOS = 3;

    private final String nome;
    private final String id;
    private final List<Emprestimo> emprestimosAtivos = new ArrayList<>();

    public Usuario(String nome, String id) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do usuário não pode ser vazio.");
        }
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public List<Emprestimo> getEmprestimosAtivos() {
        return List.copyOf(emprestimosAtivos);
    }

    boolean podePegarEmprestimo() {
        return emprestimosAtivos.size() < LIMITE_EMPRESTIMOS_ATIVOS;
    }

    void adicionarEmprestimo(Emprestimo emprestimo) {
        if (!podePegarEmprestimo()) {
            throw new IllegalStateException(
                    nome + " já atingiu o limite de " + LIMITE_EMPRESTIMOS_ATIVOS + " empréstimos ativos.");
        }
        emprestimosAtivos.add(emprestimo);
    }

    void removerEmprestimo(Emprestimo emprestimo) {
        emprestimosAtivos.remove(emprestimo);
    }

    @Override
    public String toString() {
        return nome + " (id=" + id + ", empréstimos ativos=" + emprestimosAtivos.size() + ")";
    }
}
