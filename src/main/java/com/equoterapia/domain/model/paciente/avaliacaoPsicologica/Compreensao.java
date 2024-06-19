package com.equoterapia.domain.model.paciente.avaliacaoPsicologica;

import com.equoterapia.domain.enums.PreencherLegenda;
import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Compreensao {

    // Compreensão

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompreensao;
    private PreencherLegenda compreendeOrdens;
    private PreencherLegenda executaOrdensVerbaisSimples;
    private PreencherLegenda executaOrdensComplexas;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}

