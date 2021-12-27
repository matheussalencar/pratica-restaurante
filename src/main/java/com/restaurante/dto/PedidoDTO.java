package com.restaurante.dto;

import com.restaurante.entity.Mesa;
import com.restaurante.entity.Pedido;
import com.restaurante.entity.Prato;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PedidoDTO {
    private Long id;
    private List<Prato> listaPratos;
    private Mesa mesa;
    private BigDecimal valorTotal;


    public static Pedido converte(PedidoDTO dto) {
        Pedido pedido = Pedido.builder()

                .id(dto.getId())
                .listaPratos(dto.getListaPratos())
                .mesa(dto.getMesa())
                .valorTotal(dto.getValorTotal())
                .build();

        return pedido;
    }

    public static PedidoDTO converte(Pedido pedido) {
        return PedidoDTO.builder()
                .id(pedido.getId())
                .mesa(pedido.getMesa())
                .valorTotal(pedido.getValorTotal())
                .build();
    }

    public  static List<PedidoDTO> converte(List<Pedido> pedido) {
        return pedido.stream().map(u -> converte(u)).collect(Collectors.toList());

    }

}


