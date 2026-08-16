package questao4;

public class TesteQuestao4 {
    public static void main(String[] args){
        double valorOriginal = 500.0;
        System.out.println("valorOriginal: R$ " + valorOriginal);

        EstrategiaDesconto corporativo = new DescontoClienteCorporativo();
        System.out.println("com desconto corporativo: R$ " + corporativo.aplicarDesconto(valorOriginal));

        DescontoComposto combo = new DescontoComposto();
        combo.adicionarEstrategia(new DescontoClienteCorporativo());
        combo.adicionarEstrategia(new DescontoCampanha(30.0));

        System.out.println("com desconto combo (corporativo + R$30 off): R$ " + combo.aplicarDesconto(valorOriginal));
    }
}
