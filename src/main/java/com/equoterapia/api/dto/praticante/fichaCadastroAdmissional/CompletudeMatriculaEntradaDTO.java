package com.equoterapia.api.dto.praticante.fichaCadastroAdmissional;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

import static com.equoterapia.utilidades.Resposta.ASSINATURA_IMAGEM;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompletudeMatriculaEntradaDTO {

    // Sobre a efetivação da matrícula

    private Long idCompletudeMatricula;
    private Date dataCompletudeMatricula;
    private String imagemAssinaturaResponsavel;

    @NotNull(message = "É preciso informar o praticante a ser atualizado!")
    private PraticanteIdDTO praticante;

}

