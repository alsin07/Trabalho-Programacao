package questao6;

import java.util.ArrayList;
import java.util.List;

public class Repositorio<T> {
    private List<T> dados = new ArrayList<>();

    public void salvar(T item) {
        dados.add(item);
    }

    public List<T> listarTodos() {
        return new ArrayList<>(dados);
    }

    public boolean remover(T item) {
        return dados.remove(item);
    }

    public T buscarPorIndice(int indice) {
        if (indice >= 0 && indice < dados.size()) {
            return dados.get(indice);
        }
        return null;
    }

    public static <E> void exibirDetalhes(E elementos) {
        System.out.println("elemento: " + elementos.toString());
    }

    public static <E> boolean saoIguais(E obj1, E obj2) {
        if (obj1 == null) return obj2 == null;
        return obj1.equals(obj2);
    }
}