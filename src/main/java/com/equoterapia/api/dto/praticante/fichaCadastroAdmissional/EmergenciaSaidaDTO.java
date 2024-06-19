package com.equoterapia.api.dto.praticante.fichaCadastroAdmissional;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmergenciaSaidaDTO {

    // Emergência
    private Long idEmergencia;
    private String ligarPara;
    private String telefone;
    private Boolean possuiPlanoDeSaude;
    private String plano;

}
