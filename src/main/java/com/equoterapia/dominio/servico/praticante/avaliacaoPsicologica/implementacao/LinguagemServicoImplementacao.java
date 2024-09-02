package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Linguagem;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica.LinguagemRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.LinguagemServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinguagemServicoImplementacao implements LinguagemServico {

    @Autowired
    private LinguagemRepositorio linguagemRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public Linguagem salvarLinguagem(Linguagem linguagem) {

        if (linguagem.getPraticante().getIdPraticante() != null) {

            praticanteRepositorio.findById(linguagem
                            .getPraticante()
                            .getIdPraticante())
                    .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                            Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                    + linguagem.getPraticante().getIdPraticante() + "!"
                    ));
            if (!linguagemRepositorio.buscarLinguagemPorChaveEstrangeira(linguagem.getPraticante().getIdPraticante()).isPresent()) {
                linguagem.setFinalizado(true);
                return linguagemRepositorio.save(linguagem);
            } else {
                throw new ExcecaoDeRegrasDeNegocio("A linguagem já foi cadastrada!");
            }

        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a linguagem, pois não foi possível identificar a qual praticante esse cadastro se refere!");
        }

    }

    @Override
    public Linguagem atualizarLinguagem(Linguagem linguagem) {

        if (linguagem.getIdLinguagem() == null)
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a linguagem, pois não foi possível encontra-la!");

        praticanteRepositorio.findById(linguagem
                        .getPraticante()
                        .getIdPraticante())
                .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a linguagem cadastrada!"));

        if (linguagemRepositorio.findById(linguagem.getIdLinguagem()).isPresent()) {
            linguagem.setFinalizado(true);
            return linguagemRepositorio.save(linguagem);
        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de linguagem!");
        }

    }

    @Override
    public Linguagem buscarLinguagemPorId(Long idLinguagem) {
        return linguagemRepositorio.buscarLinguagemPorChaveEstrangeira(idLinguagem).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de linguagem!"));

    }
}
