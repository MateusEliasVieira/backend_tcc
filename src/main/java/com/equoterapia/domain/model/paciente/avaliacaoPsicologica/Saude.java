package com.equoterapia.domain.model.paciente.avaliacaoPsicologica;

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
public class Saude {

    // Saúde

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSaude;
    private String alergias;
    private String convulsoes;
    private String doencas;
    private String digestao;
    private String transtornoAlimentar;
    private String respiracao;
    private String sono;
    private String deficitCognitivo;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}

