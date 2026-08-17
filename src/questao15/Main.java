package questao15;

import questao15.commands.CalculadoraCommands;
import questao15.core.CommandRegistry;
import questao15.core.CommandResult;

public class Main {

    public static void main(String[] args) {

        CommandRegistry registry =
                new CommandRegistry();

        CalculadoraCommands commands =
                new CalculadoraCommands();

        registry.register(commands);

        registry.listCommands();

        System.out.println();

        CommandResult<?> resultado1 =
                registry.execute("somar", 10, 5);

        System.out.println("Somar: " + resultado1);

        CommandResult<?> resultado2 =
                registry.execute("subtrair", 10, 5);

        System.out.println("Subtrair: " + resultado2);

        CommandResult<?> resultado3 =
                registry.execute("multiplicar", 10, 5);

        System.out.println("Multiplicar: " + resultado3);

        CommandResult<?> resultado4 =
                registry.execute("saudacao", "Joao");

        System.out.println("Saudacao: " + resultado4);

        CommandResult<?> resultado5 =
                registry.execute("dobro", 7.5);

        System.out.println("Dobro: " + resultado5);

        System.out.println();

        CommandResult<?> erro1 =
                registry.execute("somar", 10);

        System.out.println("Teste quantidade: " + erro1);

        CommandResult<?> erro2 =
                registry.execute("somar", "10", 5);

        System.out.println("Teste tipo: " + erro2);

        CommandResult<?> erro3 =
                registry.execute("dividir", 10, 5);

        System.out.println("Teste comando inexistente: " + erro3);
    }
}