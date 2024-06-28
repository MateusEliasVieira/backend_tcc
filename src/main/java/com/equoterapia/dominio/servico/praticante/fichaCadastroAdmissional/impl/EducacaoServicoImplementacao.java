package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.impl;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.EducacaoPraticante;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.EducacaoPraticanteRepositorio;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.EducacaoServico;
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
                        () -> new ExcecaoDeRegrasDeNegocio("Não foi encontrado o praticante de id "
                                + educacaoPraticante.getPraticante().getIdPraticante() +
                                " vinculado a essa educação fornecida!"));


                return educacaoPraticanteRepositorio.save(educacaoPraticante);

            } else {
                throw new ExcecaoDeRegrasDeNegocio("É preciso informar o id do paciente, que é dono da educação informada!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar os dados da educação para o devido praticante!");
        }
    }

    @Override
    public EducacaoPraticante atualizarEducacaoPraticante(EducacaoPraticante educacaoPraticante) {
        praticanteRepositorio.findById(educacaoPraticante.getPraticante().getIdPraticante()).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum praticante com id " + educacaoPraticante.getPraticante().getIdPraticante() + "!"));
        Optional<EducacaoPraticante> educacaoPraticanteExistente = educacaoPraticanteRepositorio.findById(educacaoPraticante.getIdEducacaoPraticante());
        if (educacaoPraticanteExistente.isPresent()) {
            educacaoPraticante.setIdEducacaoPraticante(educacaoPraticanteExistente.get().getIdEducacaoPraticante());
            return educacaoPraticanteRepositorio.save(educacaoPraticante);
        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não existe registros sobre a educação do praticante cadastrado no sistema!");
        }
    }

    @Override
    public EducacaoPraticante buscarEducacaoPraticante(Long idEducacaoPraticante) {
        return educacaoPraticanteRepositorio.findById(idEducacaoPraticante).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi encontrado a educação do paciente com id = " + idEducacaoPraticante + "!"));
    }

}