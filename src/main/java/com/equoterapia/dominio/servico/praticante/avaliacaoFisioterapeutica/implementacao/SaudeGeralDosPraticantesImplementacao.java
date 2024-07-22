package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.SaudeGeralDoPraticante;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica.SaudeGeralDosPraticantesRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.SaudeGeralDosPraticantesServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaudeGeralDosPraticantesImplementacao implements SaudeGeralDosPraticantesServico {
  
    @Autowired
    private SaudeGeralDosPraticantesRepositorio saudeGeralDosPraticantesRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public SaudeGeralDoPraticante salvarSaudeGeralDosPraticantes(SaudeGeralDoPraticante saudeGeralDoPraticante) {
        try {
            if (saudeGeralDoPraticante.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(saudeGeralDoPraticante
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + saudeGeralDoPraticante.getPraticante().getIdPraticante() + "!"
                        ));
                if (!saudeGeralDosPraticantesRepositorio.buscarSaudeGeralDosPraticantesPorChaveEstrangeira(saudeGeralDoPraticante.getPraticante().getIdPraticante()).isPresent()) {

                    return saudeGeralDosPraticantesRepositorio.save(saudeGeralDoPraticante);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("A saúde geral do praticante já foi cadastrado!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a saúde geral do praticante, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar a saúde geral do praticante!");
        }
    }

    @Override
    public SaudeGeralDoPraticante atualizarSaudeGeralDosPraticantes(SaudeGeralDoPraticante saudeGeralDoPraticante) {
        try {
            if (saudeGeralDoPraticante.getIdSaudeGeralDoPraticante() != null) {

                praticanteRepositorio.findById(saudeGeralDoPraticante
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a saúde geral do praticante!"));

                if (saudeGeralDosPraticantesRepositorio.findById(saudeGeralDoPraticante.getIdSaudeGeralDoPraticante()).isPresent()) {
                    return saudeGeralDosPraticantesRepositorio.save(saudeGeralDoPraticante);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de saúde geral dos praticante!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a saúde geral do praticante, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public SaudeGeralDoPraticante buscarSaudeGeralDosPraticantesPorId(Long idSaudeGeralDosPraticantes) {
        return saudeGeralDosPraticantesRepositorio.buscarSaudeGeralDosPraticantesPorChaveEstrangeira(idSaudeGeralDosPraticantes).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de saúde geral dos praticantes!"));

    }
}
