package com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.enums.PreencherLegendaEnum;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Afetividade {

    // Afetividade

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAfetividade;
    private PreencherLegendaEnum demonstraAfeicaoEspecialPorAlguem;
    private PreencherLegendaEnum compartilhaSuasCoisas;
    private PreencherLegendaEnum ajudaQuandoSolicitado;
    private PreencherLegendaEnum expressaoDeSentimentos;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

