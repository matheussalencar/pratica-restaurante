package com.restaurante.service;


import com.restaurante.controller.repository.PedidoRepository;
import com.restaurante.entity.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void create(Pedido pedido) {
        pedidoRepository.create(pedido);
    }

    public List<Pedido> listar() {
        return pedidoRepository.listar();
    }
}
