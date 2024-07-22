package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Saude;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica.SaudeRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.SaudeServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaudeServicoImplementacao implements SaudeServico {

    @Autowired
    private SaudeRepositorio saudeRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public Saude salvarSaude(Saude saude) {
        try {
            if (saude.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(saude
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + saude.getPraticante().getIdPraticante() + "!"
                        ));
                if (!saudeRepositorio.buscarSaudePorChaveEstrangeira(saude.getPraticante().getIdPraticante()).isPresent()) {

                    return saudeRepositorio.save(saude);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Os dados da saúde já foram cadastrados!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar os dados da saúde, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar os dados da saúde!");
        }
    }

    @Override
    public Saude atualizarSaude(Saude saude) {
        try {
            if (saude.getIdSaude() != null) {

                praticanteRepositorio.findById(saude
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a saúde cadastrada!"));

                if (saudeRepositorio.findById(saude.getIdSaude()).isPresent()) {
                    return saudeRepositorio.save(saude);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de saúde!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar os dados da saúde, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public Saude buscarSaudePorId(Long idSaude) {
        return saudeRepositorio.buscarSaudePorChaveEstrangeira(idSaude).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro dos dados da saúde!"));

    }
}
