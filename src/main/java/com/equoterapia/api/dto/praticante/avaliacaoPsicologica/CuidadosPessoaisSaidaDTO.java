package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CuidadosPessoaisSaidaDTO {

    // Cuidados pessoais

    private Long idCuidadosPessoais;
    private PreencherLegendaEnum higienePessoalSozinho;
    private PreencherLegendaEnum vesteRoupasCalcadosSozinho;
    private PreencherLegendaEnum seAlimentaSozinho;

}
