package com.equoterapia.dominio.servico.praticante.evolucao;

import com.equoterapia.api.dto.praticante.evolucao.EvolucaoParaGraficoSaidaDTO;
import com.equoterapia.dominio.modelo.praticante.Evolucao;

import java.util.Date;
import java.util.List;

public interface EvolucaoServico {

    public Evolucao salvarEvolucao(Evolucao evolucao);

    public Evolucao atualizarEvolucao(Evolucao evolucao);

    public List<Evolucao> listarTodasEvolucoesDoPraticante(Long idPraticante);

    public EvolucaoParaGraficoSaidaDTO buscarEvolucaoPorIntervaloDeDatas(Date dataInicial, Date dataFinal, Long idPraticante);


}
