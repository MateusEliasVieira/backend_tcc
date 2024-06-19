package com.equoterapia.api.dto.paciente.fichaCadastroAdmissional;

import com.equoterapia.api.dto.paciente.PacienteIdDTO;
import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

import static com.equoterapia.utils.Feedback.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponsavelPacienteInputDTO {

    // Responsável do paciente

    private Long idResponsavelPaciente;
    @NotBlank(message = NOME_RESPONSAVEL)
    private String nomeResponsavel;
    @NotBlank
    private String grauParentesco; // Parentesco
    @NotBlank
    private String profissao;
    @NotBlank(message = TELEFONE)
    @Pattern(regexp = "\\(\\d{2}\\)\\d{5}-\\d{4}", message = FORMATO_TELEFONE)
    private String telefone;
    @NotBlank @NotNull @Size(min = 8, max = 10)
    private Date dataNascimento;
    @Email @NotBlank(message = EMAIL)
    private String email;
    @NotBlank(message = TELEFONE_TRABALHO)
    @Pattern(regexp = "\\(\\d{2}\\)\\d{5}-\\d{4}", message = FORMATO_TELEFONE)
    private String telefoneTrabalho;
    private Double rendaFamiliar;

    private PacienteIdDTO paciente;

}

