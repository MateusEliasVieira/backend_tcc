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
    private Praticante paciente;

}

