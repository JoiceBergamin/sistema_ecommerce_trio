package com.engenharia.ecommerce.models.enums;

public enum StatusPedido {
    AGUARDANDO_PAGAMENTO, PAGO, ENVIADO, CANCELADO;

    public String statusPedido;

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }
}
