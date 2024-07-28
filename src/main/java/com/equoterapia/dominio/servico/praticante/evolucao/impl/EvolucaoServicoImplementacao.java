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

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

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

    private List<Integer> otimizarEvolucaoFrequencia(List<EvolucaoConsultaFrequenciaProjection> evolucaoConsultaFrequenciaProjectionList, List<String> meses) {
        List<Integer> listaFrequenciaAuxiliar = new ArrayList<>();
        List<Integer> listaFrequencia = new ArrayList<>();
        final Integer[] auxiliar = {0};
        meses.forEach((m) -> {
            evolucaoConsultaFrequenciaProjectionList.forEach((e) -> {
                if (FormataData.verificarMes(e.getMes()).equals(m)) {
                    auxiliar[0] += (Integer) e.getFrequencia();
                }
            });
            listaFrequenciaAuxiliar.add(auxiliar[0]);
            auxiliar[0] = 0;
        });

        for (int i = listaFrequenciaAuxiliar.size() - 1; i >= 0; i--) {
            listaFrequencia.add(listaFrequenciaAuxiliar.get(i));
        }

        return listaFrequencia;
    }

    private List<Integer> otimizarEvolucaoFaltas(List<EvolucaoConsultaFaltasProjection> evolucaoConsultaFaltasProjectionList, List<String> meses) {
        List<Integer> listaFaltasAuxiliar = new ArrayList<>();
        List<Integer> listaFaltas = new ArrayList<>();
        final Integer[] auxiliar = {0};
        meses.forEach((m) -> {
            evolucaoConsultaFaltasProjectionList.forEach((e) -> {
                if (FormataData.verificarMes(e.getMes()).equals(m)) {
                    auxiliar[0] += (Integer) e.getFaltas();
                }
            });
            listaFaltasAuxiliar.add(auxiliar[0]);
            auxiliar[0] = 0;
        });

        for (int i = listaFaltasAuxiliar.size() - 1; i >= 0; i--) {
            listaFaltas.add(listaFaltasAuxiliar.get(i));
        }

        return listaFaltas;
    }

    private List<String> inverterMeses(List<String> meses) {
        List<String> mesesInvertidos = new ArrayList<>();
        for (int i = meses.size() - 1; i >= 0; i--) {
            mesesInvertidos.add(meses.get(i));
        }

        return mesesInvertidos;
    }

    public long calcularDiasEntreDatas(Date dataInicial, Date dataFinal) {
        // Converte java.util.Date para java.time.LocalDate
        LocalDate inicio = dataInicial.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fim = dataFinal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Calcula a diferença em dias usando ChronoUnit
        return ChronoUnit.DAYS.between(inicio, fim);
    }

    // Busca apenas de um praticante
    @Override
    public EvolucaoParaGraficoSaidaDTO buscarEvolucaoPorIntervaloDeDatas(Date dataInicial, Date dataFinal, Long idPraticante) {

        try {

            if (calcularDiasEntreDatas(dataInicial, dataFinal) <= 365) {

                List<Evolucao> listaEvolucao = evolucaoRepositorio.buscarEvolucoesDoPraticanteEmIntervaloDeData(dataInicial, dataFinal, idPraticante).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe registro de evolução para o praticante entre o intervalo de datas especificado!"));
                List<EvolucaoConsultaFrequenciaProjection> frequencia = evolucaoGraficoRepositorio.buscarQuantidadeDeFrequenciaDoPraticanteParaCadaMesEmUmIntervaloDeTempo(dataInicial, dataFinal, idPraticante);
                List<EvolucaoConsultaFaltasProjection> faltas = evolucaoGraficoRepositorio.buscarQuantidadeDeFaltasDoPraticanteParaCadaMesEmUmIntervaloDeTempo(dataInicial, dataFinal, idPraticante);

                // Usando LinkedHashSet para remover duplicatas
                LinkedHashSet<String> mesesHashSet = new LinkedHashSet<>();

                listaEvolucao.forEach((e) -> {
                    Calendar calendario = Calendar.getInstance();
                    calendario.setTime(e.getData());

                    int mes = calendario.get(Calendar.MONTH) + 1; // Janeiro é 1, Dezembro é 12
                    mesesHashSet.add(FormataData.verificarMes(mes));
                });

                List<String> meses = new ArrayList<>(mesesHashSet); // recebe os meses sem repetir e converte em List
                List<Integer> listaFrequencia = otimizarEvolucaoFrequencia(frequencia, meses);
                List<Integer> listaFaltas = otimizarEvolucaoFaltas(faltas, meses);
                meses = inverterMeses(meses);

                EvolucaoParaGraficoSaidaDTO evolucaoParaGraficoSaidaDTO = new EvolucaoParaGraficoSaidaDTO();
                evolucaoParaGraficoSaidaDTO.setMeses(meses);
                evolucaoParaGraficoSaidaDTO.setFrequencia(listaFrequencia);
                evolucaoParaGraficoSaidaDTO.setFaltas(listaFaltas);

                return evolucaoParaGraficoSaidaDTO;
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Só é possível gerar gráficos com intervalo entre as datas de até 1 ano (365 dias)!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}



