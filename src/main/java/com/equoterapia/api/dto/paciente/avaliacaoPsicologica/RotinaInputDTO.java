package com.equoterapia.api.dto.paciente.avaliacaoPsicologica;

import com.equoterapia.api.dto.paciente.PacienteIdDTO;
import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RotinaInputDTO {

    // Rotina

    private Long idRotina;
    @NotBlank
    private String brincadeiras;
    @NotBlank
    private String preferenciasPorBrincadeiras;
    @NotBlank
    private Boolean aceitaMudancasNaRotina;
    @NotBlank
    private String consideracoesSobreRotina;

    private PacienteIdDTO paciente;

}

