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
public class SaudeMental {

    // Saúde mental

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSaudeMental;
    private PreencherLegendaEnum apresentaConfusaoMental;
    private PreencherLegendaEnum apresentaDelirios;
    private PreencherLegendaEnum apresentaAlucinacoes;

    private Boolean finalizado;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

