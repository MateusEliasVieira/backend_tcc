package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.AvaliacaoFisioterapeutica;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica.AvaliacaoFisioterapeuticaRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.AvaliacaoFisioterapeuticaServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoFisioterapeuticaServicoImplementacao implements AvaliacaoFisioterapeuticaServico {
  
    @Autowired
    private AvaliacaoFisioterapeuticaRepositorio avaliacaoFisioterapeuticaRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public AvaliacaoFisioterapeutica salvarAvaliacaoFisioterapeutica(AvaliacaoFisioterapeutica avaliacaoFisioterapeutica) {
        try {
            if (avaliacaoFisioterapeutica.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(avaliacaoFisioterapeutica
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + avaliacaoFisioterapeutica.getPraticante().getIdPraticante() + "!"
                        ));
                if (!avaliacaoFisioterapeuticaRepositorio.buscarAvaliacaoFisioterapeuticaPorChaveEstrangeira(avaliacaoFisioterapeutica.getPraticante().getIdPraticante()).isPresent()) {

                    return avaliacaoFisioterapeuticaRepositorio.save(avaliacaoFisioterapeutica);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Essa avaliação fisioterapeutica já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a avaliação fisioterapeutica, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar a avaliação fisioterapeutica do praticante!");
        }
    }

    @Override
    public AvaliacaoFisioterapeutica atualizarAvaliacaoFisioterapeutica(AvaliacaoFisioterapeutica avaliacaoFisioterapeutica) {
        try {
            if (avaliacaoFisioterapeutica.getIdAvaliacaoFisioterapeutica() != null) {

                praticanteRepositorio.findById(avaliacaoFisioterapeutica
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a avaliação fisioterapeutica!"));

                if (avaliacaoFisioterapeuticaRepositorio.findById(avaliacaoFisioterapeutica.getIdAvaliacaoFisioterapeutica()).isPresent()) {
                    return avaliacaoFisioterapeuticaRepositorio.save(avaliacaoFisioterapeutica);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de avaliação fisioterapeutica!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a avaliação fisioterapeutica, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public AvaliacaoFisioterapeutica buscarAvaliacaoFisioterapeuticaPorId(Long idAvaliacaoFisioterapeutica) {
        return avaliacaoFisioterapeuticaRepositorio.findById(idAvaliacaoFisioterapeutica).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de avaliação fisioterapeutica!"));

    }
}
