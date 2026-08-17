package questao12;

import java.lang.reflect.Field;

public class GeradorSQL {

    public static String gerarInsert(Object objeto) throws Exception {

        Class<?> classe = objeto.getClass();

        // Obtém o nome da tabela através da anotação @AnotaçõesPersonalizadas.Tabela
        Tabela tabela = classe.getAnnotation(Tabela.class);

        if (tabela == null) {
            throw new IllegalArgumentException(
                    "A classe não possui a anotação @AnotaçõesPersonalizadas.Tabela."
            );
        }

        String nomeTabela = tabela.nome();

        StringBuilder colunas = new StringBuilder();
        StringBuilder valores = new StringBuilder();

        Field[] campos = classe.getDeclaredFields();

        for (Field campo : campos) {

            // Verifica se o campo possui @AnotaçõesPersonalizadas.Coluna
            Coluna coluna = campo.getAnnotation(Coluna.class);

            if (coluna == null) {
                continue;
            }

            campo.setAccessible(true);

            Object valor = campo.get(objeto);

            if (colunas.length() > 0) {
                colunas.append(", ");
                valores.append(", ");
            }

            colunas.append(coluna.nome());

            if (valor instanceof String) {

                valores.append("'")
                        .append(valor)
                        .append("'");

            } else {

                valores.append(valor);

            }
        }

        return "INSERT INTO "
                + nomeTabela
                + " ("
                + colunas
                + ") VALUES ("
                + valores
                + ");";
    }
}