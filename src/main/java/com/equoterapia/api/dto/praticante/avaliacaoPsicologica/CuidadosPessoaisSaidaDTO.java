package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.Praticante;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
