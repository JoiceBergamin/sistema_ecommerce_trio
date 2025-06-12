package com.engenharia.ecommerce.models.dtos;

import com.engenharia.ecommerce.models.enums.TipoFrete;

public class CriarPedidoDTO {
    private double valorTotal;
    private TipoFrete tipoFrete;

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public TipoFrete getTipoFrete() {
        return tipoFrete;
    }

    public void setTipoFrete(TipoFrete tipoFrete) {
        this.tipoFrete = tipoFrete;
    }
}
