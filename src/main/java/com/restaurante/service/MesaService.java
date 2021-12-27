package com.restaurante.service;

import com.restaurante.controller.repository.MesaRepository;
import com.restaurante.entity.Mesa;
import com.restaurante.entity.Pedido;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MesaService {
    private MesaRepository mesaRepository;

    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    public void create (Mesa mesa) {
        mesaRepository.create(mesa);
    }

    public List<Mesa> listar() {
        return mesaRepository.listagem();
    }

    public List<Pedido> listaPedidos(Long id) {
        return mesaRepository.get(id).getListaPedidos();
    }
}
