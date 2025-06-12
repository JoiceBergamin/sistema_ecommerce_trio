package com.engenharia.ecommerce.models.state;

import com.engenharia.ecommerce.models.entities.Pedido;
import com.engenharia.ecommerce.models.enums.StatusPedido;

public class AguardandoPagamentoState implements PedidoState{
    @Override
    public void pagar(Pedido pedido) {
        pedido.setStatus(StatusPedido.PAGO);
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new IllegalArgumentException("Pagamento ainda não realizado. ");

    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setStatus(StatusPedido.CANCELADO);

    }
}
