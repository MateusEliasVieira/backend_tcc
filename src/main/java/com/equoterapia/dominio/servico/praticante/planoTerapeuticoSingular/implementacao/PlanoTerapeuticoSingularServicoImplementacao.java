package com.equoterapia.dominio.servico.praticante.planoTerapeuticoSingular.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.planoTerapeuticoSingular.PlanoTerapeuticoSingular;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.planoTerapeuticoSingular.PlanoTerapeuticoSingularRepositorio;
import com.equoterapia.dominio.servico.praticante.planoTerapeuticoSingular.PlanoTerapeuticoSingularServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanoTerapeuticoSingularServicoImplementacao implements PlanoTerapeuticoSingularServico {

    @Autowired
    private PlanoTerapeuticoSingularRepositorio planoTerapeuticoSingularRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;


    public PlanoTerapeuticoSingular salvarPlanoTerapeuticoSingular(PlanoTerapeuticoSingular planoTerapeuticoSingular) {
        try {
            if (planoTerapeuticoSingular.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(planoTerapeuticoSingular
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + planoTerapeuticoSingular.getPraticante().getIdPraticante() + "!"
                        ));
                if (!planoTerapeuticoSingularRepositorio.buscarPlanoTerapeuticoSingularPorChaveEstrangeira(planoTerapeuticoSingular.getPraticante().getIdPraticante()).isPresent()) {

                    return planoTerapeuticoSingularRepositorio.save(planoTerapeuticoSingular);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Esse plano terapêutico singular já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar o plano terapêutico singular, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar o plano terapêutico singular do praticante!");
        }
    }


    public PlanoTerapeuticoSingular atualizarPlanoTerapeuticoSingular(PlanoTerapeuticoSingular planoTerapeuticoSingular) {
        try {
            if (planoTerapeuticoSingular.getIdPlanoTerapeuticoSingular() != null) {

                praticanteRepositorio.findById(planoTerapeuticoSingular
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente ao plano terapêutico singular!"));

                if (planoTerapeuticoSingularRepositorio.findById(planoTerapeuticoSingular.getIdPlanoTerapeuticoSingular()).isPresent()) {
                    return planoTerapeuticoSingularRepositorio.save(planoTerapeuticoSingular);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de plano terapêutico singular!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar o plano terapêutico singular, pois não foi possível encontra-lo!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }


    public PlanoTerapeuticoSingular buscarPlanoTerapeuticoSingular(Long idPlanoTerapeuticoSingular) {
        return planoTerapeuticoSingularRepositorio.buscarPlanoTerapeuticoSingularPorChaveEstrangeira(idPlanoTerapeuticoSingular).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Plano terapêutico singular do praticante não encontrado!"));
    }
}
