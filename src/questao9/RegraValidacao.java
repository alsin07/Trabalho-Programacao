package questao9;

@FunctionalInterface
public interface RegraValidacao<T> {

    String validar(T objeto);
}
