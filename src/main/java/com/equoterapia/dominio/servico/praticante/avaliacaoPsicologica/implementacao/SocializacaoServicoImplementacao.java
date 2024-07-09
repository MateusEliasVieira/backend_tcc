package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Socializacao;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica.SocializacaoRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.SocializacaoServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocializacaoServicoImplementacao implements SocializacaoServico {

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;
    @Autowired
    private SocializacaoRepositorio socializacaoRepositorio;

    @Override
    public Socializacao salvarSocializacao(Socializacao socializacao) {
        try {
            if (socializacao.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(socializacao
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + socializacao.getPraticante().getIdPraticante() + "!"
                        ));
                if (!socializacaoRepositorio.buscarSocializacaoPorChaveEstrangeira(socializacao.getPraticante().getIdPraticante()).isPresent()) {

                    return socializacaoRepositorio.save(socializacao);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Essa socialização já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a socialização, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar a socialização do praticante!");
        }
    }

    @Override
    public Socializacao atualizarSocializacao(Socializacao socializacao) {
        try {
            if (socializacao.getIdSocializacao() != null) {

                praticanteRepositorio.findById(socializacao
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a socialização!"));

                if (socializacaoRepositorio.findById(socializacao.getIdSocializacao()).isPresent()) {
                    return socializacaoRepositorio.save(socializacao);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de socialização!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a socialização, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public Socializacao buscarSocializacaoPorId(Long idSocializacao) {
        return socializacaoRepositorio.findById(idSocializacao).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de socialização!"));
    }
}
