package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.enums.SImOuNaoEnum;
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
    private SImOuNaoEnum aceitaMudancasNaRotina;
    private String consideracoesSobreRotina;

}

