package questao5;

public class TesteQuestao5  {
    public static void main(String[] args) {
        Produto p1 = new Produto("notebook", 3500.00);
        Produto p2 = new Produto("mouse", 150.00);

        Carrinho carrinho = new Carrinho();
        carrinho.adicionarItem(p1, 1);
        carrinho.adicionarItem(p2, 2);

        carrinho.setValorFrete(30.00);
        carrinho.setValorDesconto(100.00);

        System.out.println("subtotal: R$ " + carrinho.calcularSubtotal());
        System.out.println("total com frete e desconto: R$ " + carrinho.calcularTotal());
    }
}