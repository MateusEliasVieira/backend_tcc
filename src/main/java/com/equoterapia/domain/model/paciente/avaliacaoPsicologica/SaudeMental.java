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
public class SaudeMental {

    // Saúde mental

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSaudeMental;
    private PreencherLegenda apresentaConfusaoMental;
    private PreencherLegenda apresentaDelirios;
    private PreencherLegenda apresentaAlucinacoes;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}

