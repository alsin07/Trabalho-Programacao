package questao4;

import java.util.ArrayList;
import java.util.List;

public class DescontoComposto implements EstrategiaDesconto {
    private List<EstrategiaDesconto> estrategias = new ArrayList<>();

    public void adicionarEstrategia(EstrategiaDesconto estrategia){
        this.estrategias.add(estrategia);
    }

    @Override
    public double aplicarDesconto(double valorOriginal){
        double valorAtual = valorOriginal;
        for (EstrategiaDesconto e : estrategias){
            valorAtual = e.aplicarDesconto(valorAtual);
        }
        return valorAtual;
    }
    }

