package questao9;

import java.util.ArrayList;
import java.util.List;

public class Validador <T> {

    private final List<RegraValidacao<T>> regras = new ArrayList<>();

    public Validador<T> adicionarRegra(RegraValidacao<T> regra) {
        regras.add(regra);
        return this;
    }

    public List<String> validar(T objeto) {

        List<String> erros = new ArrayList<>();

        for (RegraValidacao<T> regra : regras) {

            String erro = regra.validar(objeto);

            if (erro != null && !erro.isBlank()) {
                erros.add(erro);
            }
        }

        return erros;
    }

    public boolean ehValido(T objeto) {
        return validar(objeto).isEmpty();
    }
}
