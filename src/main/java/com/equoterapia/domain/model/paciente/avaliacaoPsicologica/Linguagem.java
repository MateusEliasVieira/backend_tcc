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
public class Linguagem {

    // Linguagem

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLinguagem;
    private PreencherLegenda compreensaoVerbal;
    private PreencherLegenda gesto;
    private PreencherLegenda gritos;
    private PreencherLegenda mímicaFacial;
    private PreencherLegenda monossílabos;
    private PreencherLegenda frasesCurtas;
    private PreencherLegenda frasesCompletas;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}

