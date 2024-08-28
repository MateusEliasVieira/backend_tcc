package com.equoterapia.dominio.modelo.praticante.evolucao;

import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evolucao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEvolucao;
    private Date data;
    private Boolean estavaPresente;

    @Lob // usada em JPA para indicar que um atributo de uma entidade deve ser mapeado para um tipo de objeto grande no banco de dados
    @Column(columnDefinition = "LONGTEXT")
    private String observacao;

    @ManyToOne
    @JoinColumn
    private Praticante praticante;

}
