package com.equoterapia.domain.model.paciente.avaliacaoPsicologica;

import com.equoterapia.domain.model.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SobreACrianca {

    // Perguntas iniciais sobre a criança

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSobreACrianca;
    private Boolean fezTerapiaEquina;
    private Boolean criancaPlanejada;
    private Boolean cuidadosPreNatais;
    private Boolean chorouNoNascimento;
    private String alimentacao;
    private String observacao;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Paciente paciente;

}

