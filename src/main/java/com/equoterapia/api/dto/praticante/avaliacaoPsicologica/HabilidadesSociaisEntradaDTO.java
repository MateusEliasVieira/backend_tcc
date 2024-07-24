package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HabilidadesSociaisEntradaDTO {

    // Habilidades sociais

    private Long idHabilidadesSociais;
    private PreencherLegendaEnum passividade;
    private PreencherLegendaEnum autoagressao;
    private PreencherLegendaEnum heteroagressividade;
    private PreencherLegendaEnum assertividade;

    @NotNull
    private PraticanteIdDTO praticante;

}

