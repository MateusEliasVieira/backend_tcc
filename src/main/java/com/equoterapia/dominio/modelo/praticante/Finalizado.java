package com.equoterapia.dominio.modelo.praticante;

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
public class Finalizado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFinalizado;
    private Boolean finalizado;

    @OneToOne
    @JoinColumn
    private Praticante praticante;

}
