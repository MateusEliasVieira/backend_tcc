package com.equoterapia.api.dto.praticante.fichaCadastroAdmissional;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

import static com.equoterapia.utilidades.Resposta.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponsavelPraticanteSaidaDTO {

    // Responsável do paciente

    private Long idResponsavelPraticante;
    private String nomeResponsavel;
    private String grauParentesco; // Parentesco
    private String profissao;
    private String telefone;
    private Date dataNascimento;
    private String email;
    private String telefoneTrabalho;
    private Double rendaFamiliar;

}

