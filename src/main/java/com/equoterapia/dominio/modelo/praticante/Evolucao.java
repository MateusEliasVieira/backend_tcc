package com.equoterapia.dominio.modelo.praticante;

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
    private String observacao;

    @ManyToOne
    @JoinColumn
    private Praticante praticante;

}
