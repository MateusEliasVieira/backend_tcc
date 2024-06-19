package com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.Praticante;
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
    private Praticante paciente;

}

