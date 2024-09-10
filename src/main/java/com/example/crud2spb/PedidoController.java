package com.example.crud2spb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/join")
    public List<PedidoMesaDTO> getJoinData() {
        return pedidoService.getJoinData();
    }
      // Método POST para cambiar el estado de la mesa y actualizar la columna 'fin'
    @PostMapping("/finalizar/{idPedido}")
    public String finalizarPedido(@PathVariable Long idPedido) {
        boolean isUpdated = pedidoService.finalizarPedido(idPedido);
        if (isUpdated) {
            return "Pedido finalizado correctamente.";
        } else {
            return "Error: no se pudo finalizar el pedido.";
        }
    }
}
