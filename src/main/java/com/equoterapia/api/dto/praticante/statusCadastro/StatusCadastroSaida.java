package com.equoterapia.api.dto.praticante.statusCadastro;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StatusCadastroSaida {

    // Total de tabelas analisadas
    private final int TOTAL = 33;

    // Total de tabelas concluidas
    private int finalizados = 0;

    // true = cadastro finalizado, false = não finalizado
    private boolean status = false;

}
