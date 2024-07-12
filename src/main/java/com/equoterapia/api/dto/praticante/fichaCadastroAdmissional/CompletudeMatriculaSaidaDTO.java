package com.equoterapia.api.dto.praticante.fichaCadastroAdmissional;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

import static com.equoterapia.utilidades.Resposta.ASSINATURA_IMAGEM;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompletudeMatriculaSaidaDTO {

    // Sobre a efetivação da matrícula

    private Long idCompletudeMatricula;
    private Date dataCompletudeMatricula;
    private String imagemAssinaturaResponsavel;

}

