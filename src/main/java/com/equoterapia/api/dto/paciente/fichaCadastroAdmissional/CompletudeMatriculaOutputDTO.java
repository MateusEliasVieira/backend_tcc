package com.equoterapia.api.dto.paciente.fichaCadastroAdmissional;

import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

import static com.equoterapia.utils.Feedback.ASSINATURA_IMAGEM;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompletudeMatriculaOutputDTO {

    // Sobre a efetivação da matrícula

    private Long idCompletudeMatricula;
    private Date dataCompletudeMatricula;
    @NotBlank(message = ASSINATURA_IMAGEM)
    private String imagemAssinaturaResponsavel;


}

