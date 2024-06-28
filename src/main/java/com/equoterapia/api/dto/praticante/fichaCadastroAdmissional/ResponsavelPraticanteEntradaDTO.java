package com.equoterapia.api.dto.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

import static com.equoterapia.utilidades.Resposta.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponsavelPraticanteEntradaDTO {

    // Responsável do paciente

    private Long idResponsavelPraticante;
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

    private PraticanteIdDTO praticante;

}

