package com.equoterapia.dominio.servico.praticante.evolucao.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EvolucaoConsultaFaltas {

    private Long praticante_id_praticante;
    private int ano;
    private int mes;
    private int faltas;
}
