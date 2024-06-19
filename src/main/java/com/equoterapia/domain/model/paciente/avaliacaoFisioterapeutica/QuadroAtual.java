package com.equoterapia.domain.model.paciente.avaliacaoFisioterapeutica;

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
public class QuadroAtual {

    // Quadro atual

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuadroAtual;
    private String locomocaoAtual;
    private String restricoes;
    private String deformidades;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}

