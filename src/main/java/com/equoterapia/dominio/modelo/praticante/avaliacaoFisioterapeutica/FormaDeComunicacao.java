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
public class FormaDeComunicacao {

    // Forma de comunicação

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormaDeComunicacao;
    private Boolean fala;
    private String consideracoesFala;
    private Boolean gestos;
    private String consideracoesGestos;
    private Boolean usoDosOlhos;
    private String consideracoesUsoDosOlhos;

    @OneToOne
    @JoinColumn(name = "paciente_id_fk")
    private Praticante paciente;

}

