package com.equoterapia.api.dto.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.enums.SImOuNaoEnum;
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
    private SImOuNaoEnum possuiPlanoDeSaude;
    private String plano;

}
