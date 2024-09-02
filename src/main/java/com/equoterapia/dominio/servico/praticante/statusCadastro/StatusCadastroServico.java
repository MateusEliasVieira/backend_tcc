package com.equoterapia.dominio.servico.praticante.statusCadastro;


import com.equoterapia.api.dto.praticante.statusCadastro.StatusCadastroSaida;
import com.equoterapia.dominio.repositorio.praticante.statusCadastro.StatusCadastroRepositorioCustomizado;

public class StatusCadastroServico {


    private static StatusCadastroRepositorioCustomizado scrc = new StatusCadastroRepositorioCustomizado();

    public static StatusCadastroSaida verificarQuantidadeCadastroRestante(Long idPraticante) {
        int resultado = scrc.verificarQuantidadeTotalDeCadastrosNaoFinalizadosDoPraticante(idPraticante); // se o resultado for 0, significa que não há cadastros pendentes
        StatusCadastroSaida scs = new StatusCadastroSaida();
        scs.setFinalizados(resultado == 0 ? scs.getTOTAL() : resultado);
        scs.setStatus(scs.getFinalizados() == scs.getTOTAL() ? true : false);
        return scs;
    }


}
