package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.Praticante;
import com.equoterapia.dominio.enums.PreencherLegenda;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AfetividadeSaidaDTO {

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

    private Praticante praticante;

}

