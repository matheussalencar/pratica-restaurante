package com.restaurante.controller;

import com.restaurante.dto.MesaDTO;
import com.restaurante.dto.PedidoDTO;
import com.restaurante.entity.Mesa;
import com.restaurante.entity.Pedido;
import com.restaurante.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {
    @Autowired
    private MesaService mesaService;


    @GetMapping("/{id}/pedidos")
    public ResponseEntity<List<Pedido>> obterPedidos(@PathVariable Long id) {

        return  ResponseEntity.ok(mesaService.listaPedidos(id));
    }

    @PostMapping()
    public  ResponseEntity<MesaDTO> create(@RequestBody MesaDTO dto, UriComponentsBuilder uriBuilder) {
        Mesa mesa = MesaDTO.converte(dto);
        Double totalConsumido = 0.0;
        for (int i=0; i < mesa.getListaPedidos().size(); i++) {
            for (int j =0; j < mesa.getListaPedidos().get(i).getListaPratos().size(); j++) {
                totalConsumido += (mesa.getListaPedidos().get(i).getListaPratos().get(j).getPreco() * mesa.getListaPedidos().get(i).getListaPratos().get(j).getQuantidade());
            }
            //totalConsumido += (mesa.getListaPedidos().get(i).getListaPratos().get(i).getPreco());
        }
        System.out.println(totalConsumido);
        mesa.setValorTotalConsumido(totalConsumido);
        mesaService.create(mesa);
        URI uri = uriBuilder
                .path("/mesas/{id}")
                .buildAndExpand(mesa.getId())
                .toUri();
        return ResponseEntity.created(uri).body(MesaDTO.converte(mesa));
    }

}
