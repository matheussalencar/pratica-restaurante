package com.restaurante.controller;

import com.restaurante.dto.MesaDTO;
import com.restaurante.dto.PedidoDTO;
import com.restaurante.entity.Mesa;
import com.restaurante.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {
    @Autowired
    private MesaService mesaService;


    @GetMapping("/{id}/pedidos")
    public ResponseEntity<List<PedidoDTO>> obterPedidos(@PathVariable Long id) {
        return  ResponseEntity.ok(PedidoDTO.converte(mesaService.listaPedidos(id)));
    }

    @PostMapping()
    public  ResponseEntity<MesaDTO> create(@RequestBody MesaDTO dto, UriComponentsBuilder uriBuilder) {
        Mesa mesa = MesaDTO.converte(dto);
        mesaService.create(mesa);
        URI uri = uriBuilder
                .path("/mesas/{id}")
                .buildAndExpand(mesa.getId())
                .toUri();
        return ResponseEntity.created(uri).body(MesaDTO.converte(mesa));
    }

}
