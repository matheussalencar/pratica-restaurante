package com.restaurante.dto;

import com.restaurante.entity.Mesa;
import com.restaurante.entity.Pedido;
import com.restaurante.entity.Prato;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MesaDTO {
    private Integer id;
    private List<Pedido> listaPedidos;
    private Double valorTotalConsumido;


    public static Mesa converte(MesaDTO dto) {
        Mesa mesa = Mesa.builder()

                .id(dto.getId())
                .listaPedidos(dto.getListaPedidos())
                .build();

        return mesa;
    }

    public static PratoDTO converte(Prato prato) {
        return PratoDTO.builder()
                .id(prato.getId())
                .preco(prato.getPreco())
                .description(prato.getDescricao())
                .quantity(prato.getQuantidade())
                .build();
    }

    public  static List<PratoDTO> converte(List<Prato> prato) {
        return prato.stream().map(u -> converte(u)).collect(Collectors.toList());

    }

}


