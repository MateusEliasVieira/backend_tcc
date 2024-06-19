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
    @NotBlank
    private String brincadeiras;
    @NotBlank
    private String preferenciasPorBrincadeiras;
    @NotBlank
    private Boolean aceitaMudancasNaRotina;
    @NotBlank
    private String consideracoesSobreRotina;

    private Praticante praticante;

}

