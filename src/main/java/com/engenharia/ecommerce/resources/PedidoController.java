package com.engenharia.ecommerce.resources;

import com.engenharia.ecommerce.models.dtos.CriarPedidoDTO;
import com.engenharia.ecommerce.models.entities.Pedido;
import com.engenharia.ecommerce.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity<Pedido> criar(@RequestBody CriarPedidoDTO dto){
        Pedido p = service.criarPedido(dto.getValorTotal(), dto.getTipoFrete());
        return ResponseEntity.ok(p);
    }
    @PostMapping("/{id}/pagar")
    public ResponseEntity<Pedido> pagar(@PathVariable Long id){
        return ResponseEntity.ok(service.pagar(id));
    }
    @PostMapping("/{id}/enviar")
    public ResponseEntity<Pedido> enviar(@PathVariable Long id){
        return ResponseEntity.ok(service.enviar(id));
    }
    @PostMapping("/{id}/cancelar")
    public ResponseEntity<Pedido> cancelar(@PathVariable Long id){
        return ResponseEntity.ok(service.cancelar(id));
    }
}
