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
    private PreencherLegendaEnum demonstraAfeicaoEspecialPorAlguem;
    private PreencherLegendaEnum compartilhaSuasCoisas;
    private PreencherLegendaEnum ajudaQuandoSolicitado;
    private PreencherLegendaEnum expressaoDeSentimentos;

    @NotNull
    private PraticanteIdDTO praticante;

}

