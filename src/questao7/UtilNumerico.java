package questao7;

import java.util.List;

public class UtilNumerico {

    public static double soma(List<? extends Number> numeros) {
        double soma = 0;
        for (Number numero : numeros) {
        soma += numero.doubleValue();
        }

        return soma;
}

public static double media(List<? extends Number> numeros) {
    if (numeros.isEmpty()) {
        return 0;
    }

    return soma(numeros) / numeros.size();
    }
public static <T extends Comparable<? super T>> T maior(List<T> lista) {

        if (lista.isEmpty()) {
            return null;
        }

        T maior = lista.get(0);

        for (T elemento : lista) {
            if (elemento.compareTo(maior) > 0) {
                maior = elemento;
            }
        }

        return maior;
    }

    public static <T> void copiar(
            List<? extends T> origem,
            List<? super T> destino) {

        for (T elemento : origem) {
            destino.add(elemento);
        }
    }

}