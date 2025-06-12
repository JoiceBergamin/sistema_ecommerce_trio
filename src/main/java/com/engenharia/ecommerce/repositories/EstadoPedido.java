package com.engenharia.ecommerce.repositories;

import com.engenharia.ecommerce.models.entities.Pedido;

public interface EstadoPedido {
    void Pagar (Pedido pedido);
    void Cancelar (Pedido pedido);
}
