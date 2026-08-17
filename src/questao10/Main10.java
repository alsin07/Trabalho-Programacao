package questao10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome completo da classe: ");

        String nomeClasse = scanner.nextLine();

        try {

            // Carrega a classe em tempo de execução
            Class<?> classe = Class.forName(nomeClasse);

            System.out.println("\n===== INFORMAÇÕES DA CLASSE =====");

            System.out.println(
                    "Nome da classe: " + classe.getName()
            );

            System.out.println(
                    "Modificadores: " +
                            Modifier.toString(classe.getModifiers())
            );

            // ==============================
            // ATRIBUTOS
            // ==============================

            System.out.println("\n===== ATRIBUTOS =====");

            Field[] atributos = classe.getDeclaredFields();

            for (Field atributo : atributos) {

                System.out.println(
                        "Nome: " + atributo.getName()
                );

                System.out.println(
                        "Tipo: " +
                                atributo.getType().getSimpleName()
                );

                System.out.println(
                        "Modificadores: " +
                                Modifier.toString(
                                        atributo.getModifiers()
                                )
                );

                if (Modifier.isPrivate(
                        atributo.getModifiers())) {

                    System.out.println(
                            "Este atributo é privado."
                    );
                }

                System.out.println();
            }

            // ==============================
            // CONSTRUTORES
            // ==============================

            System.out.println("\n===== CONSTRUTORES =====");

            Constructor<?>[] construtores =
                    classe.getDeclaredConstructors();

            for (Constructor<?> construtor : construtores) {

                System.out.println(
                        "Construtor: " + construtor
                );

                System.out.print("Parâmetros: ");

                Class<?>[] parametros =
                        construtor.getParameterTypes();

                if (parametros.length == 0) {

                    System.out.println("Nenhum");

                } else {

                    for (Class<?> parametro : parametros) {

                        System.out.print(
                                parametro.getSimpleName()
                                        + " "
                        );
                    }

                    System.out.println();
                }

                System.out.println();
            }

            // ==============================
            // MÉTODOS PÚBLICOS
            // ==============================

            System.out.println(
                    "\n===== MÉTODOS PÚBLICOS ====="
            );

            Method[] metodosPublicos =
                    classe.getMethods();

            for (Method metodo : metodosPublicos) {

                System.out.println(
                        "Método: " + metodo.getName()
                );

                System.out.println(
                        "Retorno: " +
                                metodo.getReturnType()
                                        .getSimpleName()
                );

                System.out.print("Parâmetros: ");

                Class<?>[] parametros =
                        metodo.getParameterTypes();

                if (parametros.length == 0) {

                    System.out.println("Nenhum");

                } else {

                    for (Class<?> parametro : parametros) {

                        System.out.print(
                                parametro.getSimpleName()
                                        + " "
                        );
                    }

                    System.out.println();
                }

                System.out.println();
            }

            // ==============================
            // MÉTODOS DECLARADOS NA PRÓPRIA CLASSE
            // ==============================

            System.out.println(
                    "\n===== MÉTODOS DECLARADOS NA CLASSE ====="
            );

            Method[] metodosDeclarados =
                    classe.getDeclaredMethods();

            for (Method metodo : metodosDeclarados) {

                System.out.println(
                        "Método: " + metodo.getName()
                );

                System.out.println(
                        "Modificadores: " +
                                Modifier.toString(
                                        metodo.getModifiers()
                                )
                );

                System.out.println(
                        "Retorno: " +
                                metodo.getReturnType()
                                        .getSimpleName()
                );

                System.out.print("Parâmetros: ");

                Class<?>[] parametros =
                        metodo.getParameterTypes();

                if (parametros.length == 0) {

                    System.out.println("Nenhum");

                } else {

                    for (Class<?> parametro : parametros) {

                        System.out.print(
                                parametro.getSimpleName()
                                        + " "
                        );
                    }

                    System.out.println();
                }

                System.out.println();
            }

        } catch (ClassNotFoundException e) {

            System.out.println(
                    "Erro: classe não encontrada."
            );

        } finally {

            scanner.close();
        }
    }
}