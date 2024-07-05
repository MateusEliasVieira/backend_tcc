package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompreensaoEntradaDTO {

    // Compreensão

    private Long idCompreensao;
    @Enumerated @NotBlank
    private PreencherLegendaEnum compreendeOrdens;
    @Enumerated @NotBlank
    private PreencherLegendaEnum executaOrdensVerbaisSimples;
    @Enumerated @NotBlank
    private PreencherLegendaEnum executaOrdensComplexas;


    private PraticanteIdDTO praticante;

}

