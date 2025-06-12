package com.engenharia.ecommerce.models.entities;

import com.engenharia.ecommerce.models.enums.StatusPedido;
import com.engenharia.ecommerce.models.enums.TipoFrete;
import jakarta.persistence.*;

@Entity
public class Pedido{
    @Id @GeneratedValue
    private Long idPedido;

    private String nomePedido;

    private double valorTotal;

    @Enumerated(EnumType.STRING)
    private TipoFrete tipoFrete;

    private double valorFrete;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    public Pedido() {
    }

    public Pedido(Long idPedido, String nomePedido, double valorTotal, TipoFrete tipoFrete, double valorFrete, StatusPedido status) {
        this.idPedido = idPedido;
        this.nomePedido = nomePedido;
        this.valorTotal = valorTotal;
        this.tipoFrete = tipoFrete;
        this.valorFrete = valorFrete;
        this.status = status;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getNomePedido() {
        return nomePedido;
    }

    public void setNomePedido(String nomePedido) {
        this.nomePedido = nomePedido;
    }

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

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
