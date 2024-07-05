package com.equoterapia.api.dto.praticante.avaliacaoPsicologica;

import com.equoterapia.api.dto.praticante.PraticanteIdDTO;
import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AfetividadeEntradaDTO {

    // Afetividade

    private Long idAfetividade;
    @Enumerated @NotNull
    private PreencherLegendaEnum demonstraAfeicaoEspecialPorAlguem;
    @Enumerated @NotNull
    private PreencherLegendaEnum compartilhaSuasCoisas;
    @Enumerated @NotNull
    private PreencherLegendaEnum ajudaQuandoSolicitado;
    @Enumerated @NotNull
    private PreencherLegendaEnum expressaoDeSentimentos;

    private PraticanteIdDTO praticante;

}

