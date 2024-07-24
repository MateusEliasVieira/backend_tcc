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
public class CompreensaoEntradaDTO {

    // Compreensão

    private Long idCompreensao;
    private PreencherLegendaEnum compreendeOrdens;
    private PreencherLegendaEnum executaOrdensVerbaisSimples;
    private PreencherLegendaEnum executaOrdensComplexas;

    @NotNull
    private PraticanteIdDTO praticante;

}

