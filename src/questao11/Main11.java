package questao11;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Main11 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            // =====================================
            // 1. RECEBER O NOME DA CLASSE
            // =====================================

            System.out.print(
                    "Digite o nome completo da classe: "
            );

            String nomeClasse = scanner.nextLine();

            Class<?> classe =
                    Class.forName(nomeClasse);

            // =====================================
            // 2. RECEBER OS ARGUMENTOS
            // =====================================

            System.out.print(
                    "Digite os argumentos separados por vírgula: "
            );

            String entrada = scanner.nextLine();

            String[] partes = entrada.isBlank()
                    ? new String[0]
                    : entrada.split(",");

            // =====================================
            // 3. LOCALIZAR CONSTRUTOR COMPATÍVEL
            // =====================================

            Constructor<?> construtorEncontrado = null;

            Object[] argumentosConvertidos = null;

            Constructor<?>[] construtores =
                    classe.getDeclaredConstructors();

            for (Constructor<?> construtor : construtores) {

                Class<?>[] tipos =
                        construtor.getParameterTypes();

                if (tipos.length != partes.length) {
                    continue;
                }

                Object[] argumentos =
                        new Object[partes.length];

                boolean compativel = true;

                for (int i = 0; i < tipos.length; i++) {

                    try {

                        argumentos[i] =
                                converter(
                                        partes[i].trim(),
                                        tipos[i]
                                );

                    } catch (Exception e) {

                        compativel = false;
                        break;
                    }
                }

                if (compativel) {

                    construtorEncontrado =
                            construtor;

                    argumentosConvertidos =
                            argumentos;

                    break;
                }
            }

            // =====================================
            // 4. VERIFICAR SE ENCONTROU
            // =====================================

            if (construtorEncontrado == null) {

                System.out.println(
                        "Nenhum construtor compatível foi encontrado."
                );

                return;
            }

            // =====================================
            // 5. CRIAR O OBJETO DINAMICAMENTE
            // =====================================

            Object objeto =
                    construtorEncontrado.newInstance(
                            argumentosConvertidos
                    );

            System.out.println(
                    "\nObjeto criado com sucesso:"
            );

            System.out.println(objeto);

        } catch (ClassNotFoundException e) {

            System.out.println(
                    "Erro: classe não encontrada."
            );

        } catch (Exception e) {

            System.out.println(
                    "Erro ao criar o objeto:"
            );

            e.printStackTrace();

        } finally {

            scanner.close();
        }
    }

    // =========================================
    // CONVERSÃO DOS ARGUMENTOS
    // =========================================

    private static Object converter(
            String valor,
            Class<?> tipo) {

        if (tipo == String.class) {

            return valor;
        }

        if (tipo == int.class ||
                tipo == Integer.class) {

            return Integer.parseInt(valor);
        }

        if (tipo == double.class ||
                tipo == Double.class) {

            return Double.parseDouble(valor);
        }

        if (tipo == boolean.class ||
                tipo == Boolean.class) {

            return Boolean.parseBoolean(valor);
        }

        if (tipo == long.class ||
                tipo == Long.class) {

            return Long.parseLong(valor);
        }

        if (tipo == float.class ||
                tipo == Float.class) {

            return Float.parseFloat(valor);
        }

        throw new IllegalArgumentException(
                "Tipo de parâmetro não suportado: "
                        + tipo.getName()
        );
    }
}