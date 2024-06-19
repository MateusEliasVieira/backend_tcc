package com.equoterapia.domain.model.paciente.avaliacaoPsicologica;

import com.equoterapia.domain.enums.PreencherLegenda;
import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comportamento {

    // Comportamento

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComportamento;
    private PreencherLegenda agitacao;
    private PreencherLegenda toleranciaFrustracao;
    private PreencherLegenda respeitaLimitesRegras;
    private PreencherLegenda oposicao;
    private PreencherLegenda atencaoConcentracao;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}
