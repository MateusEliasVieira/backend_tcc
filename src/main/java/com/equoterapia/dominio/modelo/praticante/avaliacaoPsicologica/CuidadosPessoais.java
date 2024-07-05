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
public class CuidadosPessoais {

    // Cuidados pessoais

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuidadosPessoais;
    private PreencherLegendaEnum higienePessoalSozinho;
    private PreencherLegendaEnum vesteRoupasCalcadosSozinho;
    private PreencherLegendaEnum seAlimentaSozinho;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}
