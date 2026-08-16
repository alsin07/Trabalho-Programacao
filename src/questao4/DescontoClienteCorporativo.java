package questao4;

public class DescontoClienteCorporativo implements EstrategiaDesconto {
    @Override
    public double aplicarDesconto(double valorOriginal){
        return valorOriginal * 0.85;
    }
}
