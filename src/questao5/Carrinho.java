package questao5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carrinho {
    private final List<ItemCarrinho> itens = new ArrayList<>();
    private double valorFrete;
    private double valorDesconto;

    public void adicionarItem(Produto produto, int quantidade) {
        this.itens.add(new ItemCarrinho(produto, quantidade));
    }

    public void setValorFrete(double valorFrete){
        this.valorFrete = valorFrete;
    }

    public void setValorDesconto(double valorDesconto){
        this.valorDesconto = valorDesconto;
    }

    public List<ItemCarrinho> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (ItemCarrinho item: itens) {
            subtotal += item.getSubtotalItem();
        }
        return subtotal;
    }
    public double calcularTotal() {
        return calcularSubtotal() - valorDesconto + valorFrete;
    }
}