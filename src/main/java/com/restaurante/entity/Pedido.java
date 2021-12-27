package com.restaurante.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Pedido {
    private Integer id;
    private Mesa mesa;
    private List<Prato> listaPratos;
    private double valorTotal;
}
