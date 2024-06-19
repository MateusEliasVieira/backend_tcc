package com.equoterapia.api.dto.paciente.fichaCadastroAdmissional;

import com.equoterapia.api.dto.paciente.PacienteIdDTO;
import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import static com.equoterapia.utils.Feedback.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmergenciaInputDTO {

    // Emergência

    private Long idEmergencia;
    @NotBlank(message = LIGAR_PARA)
    private String ligarPara;
    @NotBlank(message = TELEFONE)
    @Pattern(regexp = "\\(\\d{2}\\)\\d{5}-\\d{4}", message = FORMATO_TELEFONE)
    private String telefone;
    @NotNull
    private Boolean possuiPlanoDeSaude;
    private String plano; // Caso tenha, qual é?


    private PacienteIdDTO paciente;

}
