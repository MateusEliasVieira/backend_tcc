package com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica;

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
public class FormaDeComunicacao {

    // Forma de comunicação

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormaDeComunicacao;
    private SImOuNaoEnum fala;
    private String consideracoesFala;
    private SImOuNaoEnum gestos;
    private String consideracoesGestos;
    private SImOuNaoEnum usoDosOlhos;
    private String consideracoesUsoDosOlhos;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}

