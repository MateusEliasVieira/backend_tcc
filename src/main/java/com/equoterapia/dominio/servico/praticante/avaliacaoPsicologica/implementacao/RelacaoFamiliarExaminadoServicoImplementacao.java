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
        try {
            if (relacaoFamiliarExaminado.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(relacaoFamiliarExaminado
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + relacaoFamiliarExaminado.getPraticante().getIdPraticante() + "!"
                        ));
                if (!relacaoFamiliarExaminadoRepositorio.buscarRelacaoFamiliarExaminadoPorChaveEstrangeira(relacaoFamiliarExaminado.getPraticante().getIdPraticante()).isPresent()) {

                    return relacaoFamiliarExaminadoRepositorio.save(relacaoFamiliarExaminado);
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
    public RelacaoFamiliarExaminado atualizarRelacaoFamiliarExaminado(RelacaoFamiliarExaminado relacaoFamiliarExaminado) {
        try {
            if (relacaoFamiliarExaminado.getIdRelacaoFamiliarExaminado() != null) {

                praticanteRepositorio.findById(relacaoFamiliarExaminado
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a avaliacao psicologica!"));

                if (relacaoFamiliarExaminadoRepositorio.findById(relacaoFamiliarExaminado.getIdRelacaoFamiliarExaminado()).isPresent()) {
                    return relacaoFamiliarExaminadoRepositorio.save(relacaoFamiliarExaminado);
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
    public RelacaoFamiliarExaminado buscarRelacaoFamiliarExaminadoPorId(Long idRelacaoFamiliarExaminado) {
        return relacaoFamiliarExaminadoRepositorio.buscarRelacaoFamiliarExaminadoPorChaveEstrangeira(idRelacaoFamiliarExaminado).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de avaliacao psicologica!"));

    }
}
