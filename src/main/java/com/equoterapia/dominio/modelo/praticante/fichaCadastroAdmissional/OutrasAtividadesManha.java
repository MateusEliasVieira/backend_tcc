package com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional;

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
public class OutrasAtividadesManha {

    // Cronograma de atividade do paciente em outras instituições período matutino

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOutrasAtividadesManha;
    private String segundaFeira;
    private String tercaFeira;
    private String quartaFeira;
    private String quintaFeira;
    private String sextaFeira;
    private String sabado;
    private String domingo;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}
