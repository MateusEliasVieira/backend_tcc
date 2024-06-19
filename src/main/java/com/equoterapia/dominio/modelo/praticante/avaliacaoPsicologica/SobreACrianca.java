package com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica;

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
    private Praticante paciente;

}

