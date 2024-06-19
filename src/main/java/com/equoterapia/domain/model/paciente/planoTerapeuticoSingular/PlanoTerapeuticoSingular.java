package com.equoterapia.domain.model.paciente.planoTerapeuticoSingular;

import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class PlanoTerapeuticoSingular {

    // Plano Terapêutico Singular (PTS)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlanoTerapeuticoSingular;
    private Date dataPlanejamento;
    private String responsavelTerapeutico;
    private String problema;
    private String justificativaHipotesesBiologicasSociaisEmocionais;
    private String objetivoTerapeutico;
    private String medida;
    private String estrategiasIntervencao;
    private String selasMediadorasAnimais;
    private String evolucao;
    private String imagemCarimboAssinaturaTerapeutas;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}
