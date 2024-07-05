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
    @Lob // usada em JPA para indicar que um atributo de uma entidade deve ser mapeado para um tipo de objeto grande no banco de dados
    @Column(columnDefinition = "LONGTEXT")
    private String imagemAssinaturaOuCRPECarimbo;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

