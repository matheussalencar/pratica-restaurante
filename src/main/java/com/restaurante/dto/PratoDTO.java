package com.restaurante.dto;

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
public class PratoDTO {
    private Integer id;
    private String description;
    private Integer quantity;
    private BigDecimal preco;


    public static Prato converte(PratoDTO dto) {
        Prato prato = Prato.builder()

                .id(dto.getId())
                .preco(dto.getPreco())
                .descricao(dto.getDescription())
                .quantidade(dto.getQuantity())
                .build();

        return prato;
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


