package com.equoterapia.domain.model.paciente.avaliacaoFisioterapeutica;

import com.equoterapia.domain.model.paciente.Paciente;
import com.equoterapia.domain.model.patient.physicalTherapyAssessment.MobilidadeArticular;
import com.equoterapia.domain.model.patient.physicalTherapyAssessment.GruposMusculares;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class AvaliacaoFisioterapeutica {

    // Avaliação Fisioterapêutica
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvaliacaoFisioterapeutica;
    private String diagnosticoFisioterapeutico;
    private String historicoGravidez;

    // Descrever Tonus Muscular
    private String tonusMuscular;

    // Conclusão/Indicação para Equoterapia
    private String conclusaoIndicacaoEquoterapia;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}


