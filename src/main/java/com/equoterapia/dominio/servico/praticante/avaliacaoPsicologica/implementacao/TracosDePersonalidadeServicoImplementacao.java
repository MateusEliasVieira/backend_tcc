package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.TracosDePersonalidade;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica.TracosDePersonalidadeRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.TracosDePersonalidadeServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TracosDePersonalidadeServicoImplementacao implements TracosDePersonalidadeServico {

    @Autowired
    private TracosDePersonalidadeRepositorio tracosDePersonalidadeRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public TracosDePersonalidade salvarTracosDePersonalidade(TracosDePersonalidade tracosDePersonalidade) {
        try {
            if (tracosDePersonalidade.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(tracosDePersonalidade
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + tracosDePersonalidade.getPraticante().getIdPraticante() + "!"
                        ));
                if (!tracosDePersonalidadeRepositorio.buscarTracosDePersonalidadePorChaveEstrangeira(tracosDePersonalidade.getPraticante().getIdPraticante()).isPresent()) {

                    return tracosDePersonalidadeRepositorio.save(tracosDePersonalidade);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Os traços de personalidade já foi cadastrado!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar os traços de personalidade, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar os traços de personalidade do praticante!");
        }
    }

    @Override
    public TracosDePersonalidade atualizarTracosDePersonalidade(TracosDePersonalidade tracosDePersonalidade) {
        try {
            if (tracosDePersonalidade.getIdTracosDePersonalidade() != null) {

                praticanteRepositorio.findById(tracosDePersonalidade
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente aos traços de personalidade!"));

                if (tracosDePersonalidadeRepositorio.findById(tracosDePersonalidade.getIdTracosDePersonalidade()).isPresent()) {
                    return tracosDePersonalidadeRepositorio.save(tracosDePersonalidade);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de traços de personalidade!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar os traços de personalidade, pois não foi possível encontra-lo!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public TracosDePersonalidade buscarTracosDePersonalidadePorId(Long idTracosDePersonalidade) {
        return tracosDePersonalidadeRepositorio.findById(idTracosDePersonalidade).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de traços de personalidade!"));

    }
}
