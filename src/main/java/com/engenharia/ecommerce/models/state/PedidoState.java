package com.engenharia.ecommerce.models.state;

import com.engenharia.ecommerce.models.entities.Pedido;

public interface PedidoState {
    void pagar (Pedido pedido);
    void enviar(Pedido pedido);
    void cancelar(Pedido pedido);
}
