package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CuidadosPessoaisEntradaDTO {

    // Cuidados pessoais

    private Long idCuidadosPessoais;
    private PreencherLegendaEnum higienePessoalSozinho;
    private PreencherLegendaEnum vesteRoupasCalcadosSozinho;
    private PreencherLegendaEnum seAlimentaSozinho;

    @NotNull
    private PraticanteIdDTO praticante;

}
