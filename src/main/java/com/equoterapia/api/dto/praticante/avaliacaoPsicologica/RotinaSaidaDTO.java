package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.Praticante;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RotinaSaidaDTO {

    // Rotina

    private Long idRotina;
    private String brincadeiras;
    private String preferenciasPorBrincadeiras;
    private Boolean aceitaMudancasNaRotina;
    private String consideracoesSobreRotina;

}

