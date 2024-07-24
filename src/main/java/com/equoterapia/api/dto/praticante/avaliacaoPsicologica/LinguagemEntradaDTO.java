package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LinguagemEntradaDTO {

    // Linguagem

    private Long idLinguagem;
    private PreencherLegendaEnum compreensaoVerbal;
    private PreencherLegendaEnum gesto;
    private PreencherLegendaEnum gritos;
    private PreencherLegendaEnum mimicaFacial;
    private PreencherLegendaEnum monossilabos;
    private PreencherLegendaEnum frasesCurtas;
    private PreencherLegendaEnum frasesCompletas;

    @NotNull
    private PraticanteIdDTO praticante;

}

