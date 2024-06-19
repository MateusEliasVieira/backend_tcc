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
public class RelacaoFamiliarExaminado {

    // Relação da família com o examinado (percepção do entrevistador)

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRelacaoFamiliarExaminado;
    private PreencherLegenda adequado;
    private PreencherLegenda superprotecao;
    private PreencherLegenda dificuldadePerceberDeficiencias;
    private PreencherLegenda rejeicao;
    private PreencherLegenda indiferenca;
    private PreencherLegenda ansiedadePercebidaEntrevistador;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}

