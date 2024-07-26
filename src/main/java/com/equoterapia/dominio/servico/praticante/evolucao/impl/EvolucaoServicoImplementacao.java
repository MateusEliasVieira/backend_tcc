package com.equoterapia.dominio.servico.praticante.evolucao.impl;

import com.equoterapia.api.dto.praticante.evolucao.EvolucaoParaGraficoSaidaDTO;
import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.Evolucao;
import com.equoterapia.dominio.repositorio.praticante.evolucao.EvolucaoConsultaFaltasProjection;
import com.equoterapia.dominio.repositorio.praticante.evolucao.EvolucaoConsultaFrequenciaProjection;
import com.equoterapia.dominio.repositorio.praticante.evolucao.EvolucaoGraficoRepositorio;
import com.equoterapia.dominio.repositorio.praticante.evolucao.EvolucaoRepositorio;
import com.equoterapia.dominio.servico.praticante.evolucao.EvolucaoServico;
import com.equoterapia.utilidades.FormataData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class EvolucaoServicoImplementacao implements EvolucaoServico {


    @Autowired
    private EvolucaoRepositorio evolucaoRepositorio;
    @Autowired
    private EvolucaoGraficoRepositorio evolucaoGraficoRepositorio;
    @Override
    public Evolucao salvarEvolucao(Evolucao evolucao) {
        if (evolucao.getData().after(new Date(System.currentTimeMillis()))) {
            throw new ExcecaoDeRegrasDeNegocio("Não é possível aplicar data futura para evolução do praticante!");
        } else {
            if (evolucaoRepositorio.buscarEvolucaoDoPraticantePorData(evolucao.getPraticante().getIdPraticante(), evolucao.getData()).isPresent()) {
                throw new ExcecaoDeRegrasDeNegocio("Já foi aplicada anteriormente a evolução para o praticante nesta data!");
            } else {
                return evolucaoRepositorio.save(evolucao);
            }
        }
    }

    @Override
    public Evolucao atualizarEvolucao(Evolucao evolucao) {
        return null; //evolucaoRepositorio.updateEvolucaoByIdEvolucao(evolucao);
    }

    @Override
    public List<Evolucao> listarTodasEvolucoesDoPraticante(Long idPraticante) {
        return evolucaoRepositorio.buscarEvolucoesPorChaveEstrangeira(idPraticante).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Ainda não existe evolução para este praticante!"));
    }

    // Busca apenas de um praticante
    @Override
    public EvolucaoParaGraficoSaidaDTO buscarEvolucaoPorIntervaloDeDatas(Date dataInicial, Date dataFinal, Long idPraticante) {
        try {

            List<Evolucao> listaEvolucao = evolucaoRepositorio.buscarEvolucoesDoPraticanteEmIntervaloDeData(dataInicial, dataFinal, idPraticante).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe registro de evolução para o praticante entre o intervalo de datas especificado!"));
            List<EvolucaoConsultaFrequenciaProjection> frequencia = evolucaoGraficoRepositorio.buscarQuantidadeDeFrequenciaDoPraticanteParaCadaMesEmUmIntervaloDeTempo(dataInicial, dataFinal, idPraticante);
            List<EvolucaoConsultaFaltasProjection> faltas = evolucaoGraficoRepositorio.buscarQuantidadeDeFaltasDoPraticanteParaCadaMesEmUmIntervaloDeTempo(dataInicial, dataFinal, idPraticante);

            List<String> meses = new ArrayList<>();

            listaEvolucao.forEach((e) -> {
                Calendar calendario = Calendar.getInstance();
                calendario.setTime(e.getData());

                int mes = calendario.get(Calendar.MONTH) + 1; // Janeiro é 1, Dezembro é 12
                meses.add(FormataData.verificarMes(mes));
            });

            EvolucaoParaGraficoSaidaDTO evolucaoParaGraficoSaidaDTO = new EvolucaoParaGraficoSaidaDTO();
            evolucaoParaGraficoSaidaDTO.setMeses(meses);
            evolucaoParaGraficoSaidaDTO.setFrequencia(frequencia);
            evolucaoParaGraficoSaidaDTO.setFaltas(faltas);

            return evolucaoParaGraficoSaidaDTO;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }


}
