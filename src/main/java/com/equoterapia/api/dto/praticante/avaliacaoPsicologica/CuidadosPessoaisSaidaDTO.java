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
    @Enumerated @NotNull
    private PreencherLegendaEnum higienePessoalSozinho;
    @Enumerated @NotNull
    private PreencherLegendaEnum vesteRoupasCalcadosSozinho;
    @Enumerated @NotNull
    private PreencherLegendaEnum seAlimentaSozinho;


}
