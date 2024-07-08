package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Rotina;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica.RotinaRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.RotinaServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RotinaServicoImplementacao implements RotinaServico {

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;
    @Autowired
    private RotinaRepositorio rotinaRepositorio;

    @Override
    public Rotina salvarRotina(Rotina rotina) {
        try {
            if (rotina.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(rotina
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + rotina.getPraticante().getIdPraticante() + "!"
                        ));
                if (!rotinaRepositorio.buscarRotinaPorChaveEstrangeira(rotina.getPraticante().getIdPraticante()).isPresent()) {

                    return rotinaRepositorio.save(rotina);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Essa rotina já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a rotina, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar a rotina do praticante!");
        }
    }

    @Override
    public Rotina atualizarRotina(Rotina rotina) {
        try {
            if (rotina.getIdRotina() != null) {

                praticanteRepositorio.findById(rotina
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a rotina!"));

                if (rotinaRepositorio.findById(rotina.getIdRotina()).isPresent()) {
                    return rotinaRepositorio.save(rotina);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de rotina!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a rotina, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public Rotina buscarRotinaPorId(Long idRotina) {
        return rotinaRepositorio.findById(idRotina).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de rotina!"));
    }
}
