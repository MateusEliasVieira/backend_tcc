package com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.enums.SImOuNaoEnum;
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
    private SImOuNaoEnum fezTerapiaEquina;
    private SImOuNaoEnum criancaPlanejada;
    private SImOuNaoEnum cuidadosPreNatais;
    private SImOuNaoEnum chorouNoNascimento;
    private String alimentacao;
    private String observacao;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

