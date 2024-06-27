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
public class SaudeMental {

    // Saúde mental

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSaudeMental;
    private PreencherLegenda apresentaConfusaoMental;
    private PreencherLegenda apresentaDelirios;
    private PreencherLegenda apresentaAlucinacoes;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

