package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.impl;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.EducacaoPraticante;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.EducacaoPraticanteRepositorio;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.EducacaoServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EducacaoServicoImplementacao implements EducacaoServico {

    @Autowired
    private EducacaoPraticanteRepositorio educacaoPraticanteRepositorio;

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public EducacaoPraticante salvarEducacaoPraticante(EducacaoPraticante educacaoPraticante) {
        try {
            if (educacaoPraticante.getPraticante().getIdPraticante() != null) {

                // passou o id do paciente
                praticanteRepositorio.findById(
                        educacaoPraticante.getPraticante().getIdPraticante()).orElseThrow(
                        () -> new ExcecaoDeRegrasDeNegocio(Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS));

                if (!educacaoPraticanteRepositorio.buscarEducacaoPraticantePorChaveEstrangeira(educacaoPraticante.getPraticante().getIdPraticante()).isPresent()) {
                    return educacaoPraticanteRepositorio.save(educacaoPraticante);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Já foi cadastrado a educação do praticante!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível identificar a qual praticante esse cadastro se refere!");
            }

        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar os dados da educação do praticante!");
        }
    }

    @Override
    public EducacaoPraticante atualizarEducacaoPraticante(EducacaoPraticante educacaoPraticante) {
        try {
            if (educacaoPraticante.getIdEducacaoPraticante() != null) {

                praticanteRepositorio.findById(educacaoPraticante
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a educação!"));

                if (educacaoPraticanteRepositorio.findById(educacaoPraticante.getIdEducacaoPraticante()).isPresent()) {
                    return educacaoPraticanteRepositorio.save(educacaoPraticante);

                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe registros sobre a educação do praticante cadastrado no sistema!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a educação do praticante, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public EducacaoPraticante buscarEducacaoPraticante(Long idEducacaoPraticante) {
        return educacaoPraticanteRepositorio.findById(idEducacaoPraticante).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi encontrado a educação do paciente com id = " + idEducacaoPraticante + "!"));
    }

}