package com.restaurante.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Prato {
    private Integer id;
    private double preco;
    private String descricao;
    private Integer quantidade;
}
