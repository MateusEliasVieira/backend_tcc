package com.equoterapia.api.dto.paciente.avaliacaoPsicologica;

import com.equoterapia.api.dto.paciente.Paciente;
import com.equoterapia.api.dto.paciente.PacienteIdDTO;
import com.equoterapia.domain.enums.PreencherLegenda;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AfetividadeOutputDTO {

    // Afetividade

    private Long idAfetividade;
    @Enumerated @NotNull
    private PreencherLegenda demonstraAfeicaoEspecialPorAlguem;
    @Enumerated @NotNull
    private PreencherLegenda compartilhaSuasCoisas;
    @Enumerated @NotNull
    private PreencherLegenda ajudaQuandoSolicitado;
    @Enumerated @NotNull
    private PreencherLegenda expressaoDeSentimentos;

    private Paciente paciente;

}

