package com.equoterapia.dominio.servico.praticante.statusCadastro;


import com.equoterapia.api.dto.praticante.statusCadastro.StatusCadastroSaida;
import com.equoterapia.dominio.repositorio.praticante.statusCadastro.StatusCadastroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusCadastroServico {

    @Autowired
    private StatusCadastroRepositorio repositorio;

    public StatusCadastroSaida verificarQuantidadeCadastroRestante(Long idPraticante) {
        int nao_finalizados = repositorio.verificarQuantidadeTotalDeCadastrosNaoFinalizadosDoPraticante(idPraticante); // se o resultado for 0, significa que não há cadastros pendentes
        StatusCadastroSaida scs = new StatusCadastroSaida();
        scs.setFinalizados(scs.getTOTAL() - nao_finalizados);
        scs.setStatus(scs.getFinalizados() == scs.getTOTAL() ? true : false);
        return scs;
    }


}
