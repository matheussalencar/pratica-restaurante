package com.restaurante.repository;

import com.restaurante.entity.Mesa;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MesaRepository {
    private List<Mesa> mesas = new ArrayList<Mesa>();

    public void create(Mesa mesa) {
        mesa.setId((long) mesas.size() + 1);
        mesas.add(mesa);
    }

    public List<Mesa> listagem() {
        return mesas;
    }

    public Mesa get(Long id) {
        Optional<Mesa> optional=  mesas.stream().filter(m -> m.getId().equals(id)).findAny();
        System.out.println("Entrei aqui");
        System.out.println(optional.get());
        return optional.orElse(new Mesa());
    }

}
