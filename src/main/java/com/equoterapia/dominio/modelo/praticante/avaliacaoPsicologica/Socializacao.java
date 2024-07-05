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
public class Socializacao {

    // Socialização

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSocializacao;
    private PreencherLegendaEnum interageBemComOutrasCriancas;
    private PreencherLegendaEnum interageBemComAdultos;
    private PreencherLegendaEnum buscaContatoSocial;
    private PreencherLegendaEnum temOportunidadeContato;
    private PreencherLegendaEnum fazContatoVisual;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

