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
public class HabilidadesSociais {

    // Habilidades sociais

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabilidadesSociais;
    private PreencherLegenda passividade;
    private PreencherLegenda autoagressao;
    private PreencherLegenda heteroagressividade;
    private PreencherLegenda assertividade;

    @OneToOne
    @JoinColumn
    private Praticante praticante;
}

