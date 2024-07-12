package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.Praticante;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LinguagemSaidaDTO {

    // Linguagem

    private Long idLinguagem;
    private PreencherLegendaEnum compreensaoVerbal;
    private PreencherLegendaEnum gesto;
    private PreencherLegendaEnum gritos;
    private PreencherLegendaEnum mimicaFacial;
    private PreencherLegendaEnum monossilabos;
    private PreencherLegendaEnum frasesCurtas;
    private PreencherLegendaEnum frasesCompletas;

}

