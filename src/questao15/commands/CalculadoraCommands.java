package questao15.commands;

import questao15.annotations.Command;

public class CalculadoraCommands {

    @Command(name = "somar")
    public Integer somar(Integer a, Integer b) {
        return a + b;
    }

    @Command(name = "subtrair")
    public Integer subtrair(Integer a, Integer b) {
        return a - b;
    }

    @Command(name = "multiplicar")
    public Integer multiplicar(Integer a, Integer b) {
        return a * b;
    }

    @Command(name = "saudacao")
    public String saudacao(String nome) {
        return "Ola, " + nome + "!";
    }

    @Command(name = "dobro")
    public Double dobro(Double numero) {
        return numero * 2;
    }
}