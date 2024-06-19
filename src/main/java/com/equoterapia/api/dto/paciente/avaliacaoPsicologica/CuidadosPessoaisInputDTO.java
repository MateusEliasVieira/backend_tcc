package com.equoterapia.api.dto.paciente.avaliacaoPsicologica;

import com.equoterapia.api.dto.paciente.PacienteIdDTO;
import com.equoterapia.domain.enums.PreencherLegenda;
import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CuidadosPessoaisInputDTO {

    // Cuidados pessoais

    private Long idCuidadosPessoais;
    @Enumerated @NotNull
    private PreencherLegenda higienePessoalSozinho;
    @Enumerated @NotNull
    private PreencherLegenda vesteRoupasCalcadosSozinho;
    @Enumerated @NotNull
    private PreencherLegenda seAlimentaSozinho;

    private PacienteIdDTO paciente;

}
