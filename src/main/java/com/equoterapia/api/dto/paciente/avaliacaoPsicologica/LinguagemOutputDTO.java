package com.equoterapia.api.dto.paciente.avaliacaoPsicologica;

import com.equoterapia.api.dto.paciente.Paciente;
import com.equoterapia.domain.enums.PreencherLegenda;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LinguagemOutputDTO {

    // Linguagem

    private Long idLinguagem;
    @Enumerated @NotNull
    private PreencherLegenda compreensaoVerbal;
    @Enumerated @NotNull
    private PreencherLegenda gesto;
    @Enumerated @NotNull
    private PreencherLegenda gritos;
    @Enumerated @NotNull
    private PreencherLegenda mimicaFacial;
    @Enumerated @NotNull
    private PreencherLegenda monossilabos;
    @Enumerated @NotNull
    private PreencherLegenda frasesCurtas;
    @Enumerated @NotNull
    private PreencherLegenda frasesCompletas;


    private Paciente paciente;

}

