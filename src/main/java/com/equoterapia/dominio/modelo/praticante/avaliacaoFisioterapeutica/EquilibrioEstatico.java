package com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica;

import com.equoterapia.dominio.enums.EquilibrioEstaticoEnum;
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
    private EquilibrioEstaticoEnum apoioCabeca;
    private String comentariosApoioCabeca;
    private EquilibrioEstaticoEnum sentarSemApoio;
    private String comentariosSentarSemApoio;
    private EquilibrioEstaticoEnum sentarComApoio;
    private String comentariosSentarComApoio;
    private EquilibrioEstaticoEnum emPeSemApoio;
    private String comentariosEmPeSemApoio;
    private EquilibrioEstaticoEnum emPeComApoio;
    private String comentariosEmPeComApoio;
    private EquilibrioEstaticoEnum posicaoDeSentinelaOlhosAbertos;
    private String comentariosPosicaoDeSentinelaOlhosAbertos;
    private EquilibrioEstaticoEnum posicaoDeSentinelaOlhosFechados;
    private String comentariosPosicaoDeSentinelaOlhosFechados;
    private EquilibrioEstaticoEnum umPeOlhosAbertos;
    private String comentariosUmPeOlhosAbertos;
    private EquilibrioEstaticoEnum umPeOlhosFechados;
    private String comentariosUmPeOlhosFechados;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}
