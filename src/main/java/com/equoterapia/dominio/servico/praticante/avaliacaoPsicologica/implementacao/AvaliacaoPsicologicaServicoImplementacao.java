package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.AvaliacaoPsicologica;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica.AvaliacaoPsicologicaRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.AvaliacaoPsicologicaServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoPsicologicaServicoImplementacao implements AvaliacaoPsicologicaServico {

    @Autowired
    private AvaliacaoPsicologicaRepositorio avaliacaoPsicologicaRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public AvaliacaoPsicologica salvarAvaliacaoPsicologica(AvaliacaoPsicologica avaliacaoPsicologica) {
        try {
            if (avaliacaoPsicologica.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(avaliacaoPsicologica
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + avaliacaoPsicologica.getPraticante().getIdPraticante() + "!"
                        ));
                if (!avaliacaoPsicologicaRepositorio.buscarAvaliacaoPsicologicaPorChaveEstrangeira(avaliacaoPsicologica.getPraticante().getIdPraticante()).isPresent()) {

                    return avaliacaoPsicologicaRepositorio.save(avaliacaoPsicologica);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Essa avaliacao psicologica já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a avaliacao psicologica, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar a avaliacao psicologica do praticante!");
        }
    }

    @Override
    public AvaliacaoPsicologica atualizarAvaliacaoPsicologica(AvaliacaoPsicologica avaliacaoPsicologica) {
        try {
            if (avaliacaoPsicologica.getIdAvaliacaoPsicologica() != null) {

                praticanteRepositorio.findById(avaliacaoPsicologica
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a avaliacao psicologica!"));

                if (avaliacaoPsicologicaRepositorio.findById(avaliacaoPsicologica.getIdAvaliacaoPsicologica()).isPresent()) {
                    return avaliacaoPsicologicaRepositorio.save(avaliacaoPsicologica);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de avaliacao psicologica!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a avaliacao psicologica, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public AvaliacaoPsicologica buscarAvaliacaoPsicologicaPorId(Long idAvaliacaoPsicologica) {
        return avaliacaoPsicologicaRepositorio.findById(idAvaliacaoPsicologica).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de avaliacao psicologica!"));

    }
}
