package com.restaurante.service;

import com.restaurante.repository.PratoRepository;
import com.restaurante.entity.Prato;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PratoService {

    private PratoRepository pratoRepository;

    public PratoService(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }

    public void salvar(Prato prato) {
        pratoRepository.create(prato);
    }

    public List<Prato> listar() {
        return pratoRepository.listar();
    }
}
