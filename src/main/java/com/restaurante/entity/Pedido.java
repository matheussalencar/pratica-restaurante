package com.restaurante.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Pedido {
    private Long id;
    private List<Prato> listaPratos;
    private Double valorTotal;
}
