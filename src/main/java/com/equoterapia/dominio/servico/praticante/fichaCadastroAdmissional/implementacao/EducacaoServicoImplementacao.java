package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.EducacaoPraticante;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.EducacaoPraticanteRepositorio;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.EducacaoServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacaoServicoImplementacao implements EducacaoServico {

    @Autowired
    private EducacaoPraticanteRepositorio educacaoPraticanteRepositorio;

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public EducacaoPraticante salvarEducacaoPraticante(EducacaoPraticante educacaoPraticante) {

        if (educacaoPraticante.getPraticante().getIdPraticante() != null) {

            // passou o id do paciente
            praticanteRepositorio.findById(
                    educacaoPraticante.getPraticante().getIdPraticante()).orElseThrow(
                    () -> new ExcecaoDeRegrasDeNegocio(Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS));

            if (!educacaoPraticanteRepositorio.buscarEducacaoPraticantePorChaveEstrangeira(educacaoPraticante.getPraticante().getIdPraticante()).isPresent()) {
                educacaoPraticante.setFinalizado(true);
                return educacaoPraticanteRepositorio.save(educacaoPraticante);
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Já foi cadastrado a educação do praticante!");
            }

        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível identificar a qual praticante esse cadastro se refere!");
        }


    }

    @Override
    public EducacaoPraticante atualizarEducacaoPraticante(EducacaoPraticante educacaoPraticante) {

        if (educacaoPraticante.getIdEducacaoPraticante() == null)
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não foi encontrado o id da educação!");
        praticanteRepositorio.findById(educacaoPraticante
                        .getPraticante()
                        .getIdPraticante())
                .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a educação!"));

        if (educacaoPraticanteRepositorio.findById(educacaoPraticante.getIdEducacaoPraticante()).isPresent()) {
            educacaoPraticante.setFinalizado(true);
            return educacaoPraticanteRepositorio.save(educacaoPraticante);
        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe registros sobre a educação do praticante cadastrado no sistema!");
        }

    }

    @Override
    public EducacaoPraticante buscarEducacaoPraticante(Long idEducacaoPraticante) {
        return educacaoPraticanteRepositorio.buscarEducacaoPraticantePorChaveEstrangeira(idEducacaoPraticante).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Educação do praticante não encontrada!"));
    }

}