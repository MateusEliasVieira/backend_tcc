package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.PreencherLegenda;
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
    @Enumerated @NotNull
    private PreencherLegenda higienePessoalSozinho;
    @Enumerated @NotNull
    private PreencherLegenda vesteRoupasCalcadosSozinho;
    @Enumerated @NotNull
    private PreencherLegenda seAlimentaSozinho;

    private PraticanteIdDTO paciente;

}
