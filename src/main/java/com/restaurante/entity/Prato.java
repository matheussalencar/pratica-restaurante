package com.restaurante.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Prato {
    private Long id;
    private BigDecimal preco;
    private String descricao;
    private Integer quantidade;
}
