package com.engenharia.ecommerce.services;

import com.engenharia.ecommerce.models.entities.Pedido;
import com.engenharia.ecommerce.models.enums.StatusPedido;
import com.engenharia.ecommerce.models.enums.TipoFrete;
import com.engenharia.ecommerce.models.state.AguardandoPagamentoState;
import com.engenharia.ecommerce.models.state.PagoState;
import com.engenharia.ecommerce.models.state.PedidoState;
import com.engenharia.ecommerce.models.strategy.FreteFactory;
import com.engenharia.ecommerce.models.strategy.FreteStrategy;
import com.engenharia.ecommerce.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.engenharia.ecommerce.models.enums.StatusPedido.*;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepo;

    public Pedido criarPedido(double valor, TipoFrete tipoFrete){
        FreteStrategy strategy = FreteFactory.obterFrete(tipoFrete);
        double frete = strategy.calcularFrete(valor);

        Pedido pedido = new Pedido();
        pedido.setValorTotal(valor);
        pedido.setValorFrete(frete);
        pedido.setTipoFrete(tipoFrete);
        pedido.setStatus(AGUARDANDO_PAGAMENTO);
        return pedidoRepo.save(pedido);
    }
    public Pedido pagar(Long id){
        Pedido pedido = pedidoRepo.findById(id).orElseThrow();
        validarEstado(pedido).pagar(pedido);
        return pedidoRepo.save(pedido);
    }
    public Pedido enviar(Long id){
        Pedido pedido = pedidoRepo.findById(id).orElseThrow();
        validarEstado(pedido).enviar(pedido);
        return pedidoRepo.save(pedido);
    }
    public Pedido cancelar(Long id){
        Pedido pedido = pedidoRepo.findById(id).orElseThrow();
        validarEstado(pedido).cancelar(pedido);
        return pedidoRepo.save(pedido);
    }
    private PedidoState validarEstado(Pedido pedido){
        switch (pedido.getStatus()){
            case AGUARDANDO_PAGAMENTO: return new AguardandoPagamentoState();
            case PAGO: return new PagoState();
            case ENVIADO:
            case CANCELADO: throw new IllegalArgumentException("Pedido não pode ser alterado. ");
            default: throw new IllegalStateException("Estado inválido. ");
        }
    }

}
