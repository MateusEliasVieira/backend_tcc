package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Afetividade;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica.AfetividadeRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.AfetividadeServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AfetividadeServicoImplementacao implements AfetividadeServico {

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;
    @Autowired
    private AfetividadeRepositorio afetividadeRepositorio;

    @Override
    public Afetividade salvarAfetividade(Afetividade afetividade) {
        try {
            if (afetividade.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(afetividade
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + afetividade.getPraticante().getIdPraticante() + "!"
                        ));
                if (!afetividadeRepositorio.buscarAfetividadePorChaveEstrangeira(afetividade.getPraticante().getIdPraticante()).isPresent()) {

                    return afetividadeRepositorio.save(afetividade);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Essa afetividade já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a afetividade, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar a afetividade do praticante!");
        }
    }

    @Override
    public Afetividade atualizarAfetividade(Afetividade afetividade) {
        try {
            if (afetividade.getIdAfetividade() != null) {

                praticanteRepositorio.findById(afetividade
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a afetividade!"));

                if (afetividadeRepositorio.findById(afetividade.getIdAfetividade()).isPresent()) {
                    return afetividadeRepositorio.save(afetividade);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de afetividade!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a afetividade, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public Afetividade buscarAfetividadePorId(Long idAfetividade) {
        return afetividadeRepositorio.findById(idAfetividade).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de afetividade!"));
    }
}
