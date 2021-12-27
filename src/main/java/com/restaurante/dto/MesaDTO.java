package com.restaurante.dto;

import com.restaurante.entity.Mesa;
import com.restaurante.entity.Pedido;
import com.restaurante.entity.Prato;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MesaDTO {
    private Long id;
    private List<Pedido> listaPedidos;
    private Double valorTotalConsumido;


    public static Mesa converte(MesaDTO dto) {
        Mesa mesa = Mesa.builder()
                .id(dto.getId())
                .listaPedidos(dto.getListaPedidos())
                .valorTotalConsumido(dto.getValorTotalConsumido())
                .build();

        return mesa;
    }

    public static MesaDTO converte(Mesa mesa) {
        return MesaDTO.builder()
                .id(mesa.getId())
                .listaPedidos(mesa.getListaPedidos())
                .valorTotalConsumido(mesa.getValorTotalConsumido())
                .build();
    }

    public  static List<MesaDTO> converte(List<Mesa> mesa) {
        return mesa.stream().map(m -> converte(m)).collect(Collectors.toList());

    }

}


