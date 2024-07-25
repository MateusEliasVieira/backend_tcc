package com.equoterapia.dominio.servico.praticante.evolucao.impl;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.Evolucao;
import com.equoterapia.dominio.repositorio.praticante.evolucao.EvolucaoRepositorio;
import com.equoterapia.dominio.servico.praticante.evolucao.EvolucaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvolucaoServicoImplementacao implements EvolucaoServico {


    @Autowired
    private EvolucaoRepositorio evolucaoRepositorio;

    @Override
    public Evolucao salvarEvolucao(Evolucao evolucao) {
        return evolucaoRepositorio.save(evolucao);
    }

    @Override
    public Evolucao atualizarEvolucao(Evolucao evolucao) {
        return null; //evolucaoRepositorio.updateEvolucaoByIdEvolucao(evolucao);
    }

    @Override
    public List<Evolucao> listarTodasEvolucoesDoPraticante(Long idPraticante) {
        return evolucaoRepositorio.buscarEvolucoesPorChaveEstrangeira(idPraticante).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Ainda não existe evolução para este praticante!"));
    }
}
