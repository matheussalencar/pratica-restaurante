package com.restaurante.repository;

import com.restaurante.entity.Pedido;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PedidoRepository {

    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public void create(Pedido pedido) {
        pedido.setId((long) pedidos.size() + 1);
        pedidos.add(pedido);
    }

    public List<Pedido> listar() {
        return pedidos;
    }

    public Pedido get(Long id) {
        Optional<Pedido> optional=  pedidos.stream().filter(p -> p.getId().equals(id)).findAny();
        return  optional.orElse(new Pedido());
    }
}
