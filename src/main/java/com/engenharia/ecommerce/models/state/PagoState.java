package com.engenharia.ecommerce.models.state;

import com.engenharia.ecommerce.models.entities.Pedido;
import com.engenharia.ecommerce.models.enums.StatusPedido;

public class PagoState implements PedidoState {


    @Override
    public void pagar(Pedido pedido) {
        throw new IllegalArgumentException("O pedido já foi pago.");

    }

    @Override
    public void enviar(Pedido pedido) {
        pedido.setStatus(StatusPedido.ENVIADO);

    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalArgumentException("Pedido já pago não pode mais ser cancelado");

    }
}