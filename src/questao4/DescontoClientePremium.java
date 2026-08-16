package questao4;

public class DescontoClientePremium implements EstrategiaDesconto{
    @Override
    public double aplicarDesconto(double valorOriginal){
        return valorOriginal * 0.90;
    }
}
