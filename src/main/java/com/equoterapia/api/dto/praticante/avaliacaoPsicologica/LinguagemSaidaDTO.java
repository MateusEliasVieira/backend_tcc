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
    @Enumerated @NotNull
    private PreencherLegendaEnum compreensaoVerbal;
    @Enumerated @NotNull
    private PreencherLegendaEnum gesto;
    @Enumerated @NotNull
    private PreencherLegendaEnum gritos;
    @Enumerated @NotNull
    private PreencherLegendaEnum mimicaFacial;
    @Enumerated @NotNull
    private PreencherLegendaEnum monossilabos;
    @Enumerated @NotNull
    private PreencherLegendaEnum frasesCurtas;
    @Enumerated @NotNull
    private PreencherLegendaEnum frasesCompletas;


    private Praticante praticante;

}

