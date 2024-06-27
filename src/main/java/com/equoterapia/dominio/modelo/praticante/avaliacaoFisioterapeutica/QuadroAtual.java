package com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.modelo.praticante.Praticante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class QuadroAtual {

    // Quadro atual

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuadroAtual;
    private String locomocaoAtual;
    private String restricoes;
    private String deformidades;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

