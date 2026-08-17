package questao8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class test8 {

    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(
                new Funcionario("Carlos", 3000, "TI")
        );

        funcionarios.add(
                new Funcionario("Ana", 4500, "Financeiro")
        );

        funcionarios.add(
                new Funcionario("Bruno", 2500, "RH")
        );

        funcionarios.add(
                new Funcionario("Daniela", 6000, "TI")
        );


        System.out.println("=== ORDEM NATURAL: NOME ===");

        funcionarios.sort(null);

        funcionarios.forEach(System.out::println);


        System.out.println("\n=== SALÁRIO CRESCENTE ===");

        funcionarios.sort(
                ComparadoresFuncionarios.porSalarioCrescente()
        );

        funcionarios.forEach(System.out::println);


        System.out.println("\n=== SALÁRIO DECRESCENTE ===");

        funcionarios.sort(
                ComparadoresFuncionarios.porSalarioDecrescente()
        );

        funcionarios.forEach(System.out::println);


        System.out.println("\n=== POR SETOR ===");

        funcionarios.sort(
                ComparadoresFuncionarios.porSetor()
        );

        funcionarios.forEach(System.out::println);
    }
}
