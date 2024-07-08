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
    private LinguagemRepositorio saudeRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public Linguagem salvarLinguagem(Linguagem saude) {
        try {
            if (saude.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(saude
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + saude.getPraticante().getIdPraticante() + "!"
                        ));
                if (!saudeRepositorio.buscarLinguagemPorChaveEstrangeira(saude.getPraticante().getIdPraticante()).isPresent()) {

                    return saudeRepositorio.save(saude);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("A linguagem já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a linguagem, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar a linguagem!");
        }
    }

    @Override
    public Linguagem atualizarLinguagem(Linguagem saude) {
        try {
            if (saude.getIdLinguagem() != null) {

                praticanteRepositorio.findById(saude
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a linguagem cadastrada!"));

                if (saudeRepositorio.findById(saude.getIdLinguagem()).isPresent()) {
                    return saudeRepositorio.save(saude);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de linguagem!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a linguagem, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public Linguagem buscarLinguagemPorId(Long idLinguagem) {
        return saudeRepositorio.findById(idLinguagem).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de linguagem!"));

    }
}
