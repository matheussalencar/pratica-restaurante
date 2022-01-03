package com.restaurante.service;

import com.restaurante.repository.MesaRepository;
import com.restaurante.entity.Mesa;
import com.restaurante.entity.Pedido;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MesaService {
    private MesaRepository mesaRepository;

    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    public void create (Mesa mesa) {
        try {
            mesaRepository.create(mesa);
        } catch (RuntimeException e) {
            throw new RuntimeException("Falha ao cadastrar");
        }
    }

    public List<Mesa> listar() {
        return mesaRepository.listagem();
    }

    public List<Pedido> listaPedidos(Long id) {

        return mesaRepository.get(id).getListaPedidos();
    }
}
