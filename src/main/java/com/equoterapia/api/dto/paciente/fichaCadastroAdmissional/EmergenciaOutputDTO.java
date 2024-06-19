package com.equoterapia.api.dto.paciente.fichaCadastroAdmissional;

import com.equoterapia.domain.model.paciente.Paciente;
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
public class EmergenciaOutputDTO {

    // Emergência
    private Long idEmergencia;
    private String ligarPara;
    private String telefone;
    private Boolean possuiPlanoDeSaude;
    private String plano;

}
