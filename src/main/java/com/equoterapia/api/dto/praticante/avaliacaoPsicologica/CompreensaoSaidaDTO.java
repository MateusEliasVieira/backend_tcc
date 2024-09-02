package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompreensaoSaidaDTO {

    // Compreensão

    private Long idCompreensao;
    private PreencherLegendaEnum compreendeOrdens;
    private PreencherLegendaEnum executaOrdensVerbaisSimples;
    private PreencherLegendaEnum executaOrdensComplexas;

    private Boolean finalizado;

    private PraticanteIdDTO praticante;

}

