package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.Praticante;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
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
    private PreencherLegendaEnum demonstraAfeicaoEspecialPorAlguem;
    private PreencherLegendaEnum compartilhaSuasCoisas;
    private PreencherLegendaEnum ajudaQuandoSolicitado;
    private PreencherLegendaEnum expressaoDeSentimentos;

}

