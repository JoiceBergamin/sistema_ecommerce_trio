package com.engenharia.ecommerce.models.strategy;

public class FreteAereo implements FreteStrategy{
    @Override
    public double calcularFrete(double valorPedido) {
        return valorPedido * 0.10;
    }
}
