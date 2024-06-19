package com.equoterapia.domain.model.paciente.avaliacaoPsicologica;

import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class AvaliacaoPsicologica {

    // Avaliação dos aspectos psicológicos

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvaliacaoPsicologica;
    private String expectativasFamiliaresTerapiaEquina;
    private String resumoCasoObservacoesComplementares;
    private String imagemAssinaturaOuCRPECarimbo;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}

