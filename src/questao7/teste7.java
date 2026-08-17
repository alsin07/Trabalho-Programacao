package questao7;

import java.util.ArrayList;
import java.util.List;

public class teste7 {

    public static void main(String[] args) {

        List<Integer> numeros = List.of(10, 20, 30, 40, 50);

        System.out.println("Númeoros: " + numeros);
        
        System.out.println("Soma: "
                + UtilNumerico.soma(numeros));

        System.out.println("Média: "
                + UtilNumerico.media(numeros));

        System.out.println("Maior: "
                + UtilNumerico.maior(numeros));


        List<Integer> origem = List.of(1, 2, 3);

        List<Number> destino = new ArrayList<>();

        UtilNumerico.copiar(origem, destino);

        System.out.println("Lista destino: " + destino);
    }
}

