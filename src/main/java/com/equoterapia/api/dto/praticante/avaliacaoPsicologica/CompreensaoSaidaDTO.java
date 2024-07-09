package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.Praticante;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompreensaoSaidaDTO {

    // Compreensão

    private Long idCompreensao;
    @Enumerated @NotBlank
    private PreencherLegendaEnum compreendeOrdens;
    @Enumerated @NotBlank
    private PreencherLegendaEnum executaOrdensVerbaisSimples;
    @Enumerated @NotBlank
    private PreencherLegendaEnum executaOrdensComplexas;

}

