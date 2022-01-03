package com.restaurante.repository;


import com.restaurante.entity.Prato;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PratoRepository {
    private List <Prato> pratos = new ArrayList<Prato>();

    public void create(Prato prato) {
        prato.setId((long) pratos.size() + 1);
        pratos.add(prato);
    }

    public List<Prato> listar() {
        return  pratos;
    }

    public Prato get(Long id) {
        Optional<Prato> optional =  pratos.stream().filter(p -> p.getId().equals(id)).findAny();
        return  optional.orElse(new Prato());
    }
}
