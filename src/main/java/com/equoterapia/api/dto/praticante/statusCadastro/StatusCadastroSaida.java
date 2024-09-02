package com.equoterapia.api.dto.praticante.statusCadastro;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StatusCadastroSaida {

    // Total de tabelas analisadas
    private final int TOTAL = 36;

    // Total de tabelas concluidas
    private int finalizados;

    // true = cadastro finalizado, false = não finalizado
    private boolean status;

}
