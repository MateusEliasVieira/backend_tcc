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
public class EquilibrioEstatico {

    // Equilíbrio Estático

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquilibrioEstatico;
    private com.equoterapia.dominio.enums.EquilibrioEstatico apoioCabeca;
    private String comentariosApoioCabeca;
    private com.equoterapia.dominio.enums.EquilibrioEstatico sentarSemApoio;
    private String comentariosSentarSemApoio;
    private com.equoterapia.dominio.enums.EquilibrioEstatico sentarComApoio;
    private String comentariosSentarComApoio;
    private com.equoterapia.dominio.enums.EquilibrioEstatico emPeSemApoio;
    private String comentariosEmPeSemApoio;
    private com.equoterapia.dominio.enums.EquilibrioEstatico emPeComApoio;
    private String comentariosEmPeComApoio;
    private com.equoterapia.dominio.enums.EquilibrioEstatico posicaoDeSentinelaOlhosAbertos;
    private String comentariosPosicaoDeSentinelaOlhosAbertos;
    private com.equoterapia.dominio.enums.EquilibrioEstatico posicaoDeSentinelaOlhosFechados;
    private String comentariosPosicaoDeSentinelaOlhosFechados;
    private com.equoterapia.dominio.enums.EquilibrioEstatico umPeOlhosAbertos;
    private String comentariosUmPeOlhosAbertos;
    private com.equoterapia.dominio.enums.EquilibrioEstatico umPeOlhosFechados;
    private String comentariosUmPeOlhosFechados;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}
