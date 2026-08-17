package questao8;

import java.util.Comparator;

public class ComparadoresFuncionarios {

    public static Comparator<Funcionario> porSalarioCrescente() {
        return Comparator.comparingDouble(Funcionario::getSalario);
    }

    public static Comparator<Funcionario> porSalarioDecrescente() {
        return Comparator.comparingDouble(Funcionario::getSalario)
                .reversed();
    }

    public static Comparator<Funcionario> porSetor() {
        return Comparator.comparing(
                Funcionario::getSetor,
                String.CASE_INSENSITIVE_ORDER
        );
    }
}
