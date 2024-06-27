package com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.enums.PreencherLegenda;
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
    private PreencherLegenda demonstraAfeicaoEspecialPorAlguem;
    private PreencherLegenda compartilhaSuasCoisas;
    private PreencherLegenda ajudaQuandoSolicitado;
    private PreencherLegenda expressaoDeSentimentos;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

