package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.RelacaoFamiliarExaminado;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica.RelacaoFamiliarExaminadoRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.RelacaoFamiliarExaminadoServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelacaoFamiliarExaminadoServicoImplementacao implements RelacaoFamiliarExaminadoServico {

    @Autowired
    private RelacaoFamiliarExaminadoRepositorio relacaoFamiliarExaminadoRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public RelacaoFamiliarExaminado salvarRelacaoFamiliarExaminado(RelacaoFamiliarExaminado relacaoFamiliarExaminado) {

        if (relacaoFamiliarExaminado.getPraticante().getIdPraticante() != null) {

            praticanteRepositorio.findById(relacaoFamiliarExaminado
                            .getPraticante()
                            .getIdPraticante())
                    .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                            Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                    + relacaoFamiliarExaminado.getPraticante().getIdPraticante() + "!"
                    ));
            if (!relacaoFamiliarExaminadoRepositorio.buscarRelacaoFamiliarExaminadoPorChaveEstrangeira(relacaoFamiliarExaminado.getPraticante().getIdPraticante()).isPresent()) {
                relacaoFamiliarExaminado.setFinalizado(true);
                return relacaoFamiliarExaminadoRepositorio.save(relacaoFamiliarExaminado);
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Essa relação da família com o examinado já foi cadastrada!");
            }

        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a relação da família com o examinado, pois não foi possível identificar a qual praticante esse cadastro se refere!");
        }

    }

    @Override
    public RelacaoFamiliarExaminado atualizarRelacaoFamiliarExaminado(RelacaoFamiliarExaminado relacaoFamiliarExaminado) {

        if (relacaoFamiliarExaminado.getIdRelacaoFamiliarExaminado() == null)
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a relação da família com o examinado, pois não foi possível encontra-la!");

        praticanteRepositorio.findById(relacaoFamiliarExaminado
                        .getPraticante()
                        .getIdPraticante())
                .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a relação da família com o examinado!"));

        if (relacaoFamiliarExaminadoRepositorio.findById(relacaoFamiliarExaminado.getIdRelacaoFamiliarExaminado()).isPresent()) {
            relacaoFamiliarExaminado.setFinalizado(true);
            return relacaoFamiliarExaminadoRepositorio.save(relacaoFamiliarExaminado);
        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de relação da família com o examinado!");
        }

    }

    @Override
    public RelacaoFamiliarExaminado buscarRelacaoFamiliarExaminadoPorId(Long idRelacaoFamiliarExaminado) {
        return relacaoFamiliarExaminadoRepositorio.buscarRelacaoFamiliarExaminadoPorChaveEstrangeira(idRelacaoFamiliarExaminado).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de relação da família com o examinado!"));

    }
}
