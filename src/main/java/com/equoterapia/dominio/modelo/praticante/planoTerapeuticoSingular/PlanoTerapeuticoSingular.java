package com.equoterapia.dominio.modelo.praticante.planoTerapeuticoSingular;

import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.persistence.*;
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
    @JoinColumn(name = "praticante_id_fk")
    private Praticante praticante;

}
