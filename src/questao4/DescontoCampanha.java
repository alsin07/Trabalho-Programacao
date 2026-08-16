package questao4;

public class DescontoCampanha implements EstrategiaDesconto {
    private double valorFixo;

    public DescontoCampanha(double valorFixo){
        this.valorFixo = valorFixo;
    }

    @Override
    public double aplicarDesconto(double valorOriginal){
        return Math.max(0, valorOriginal - valorFixo);
    }
}