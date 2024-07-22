package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.GruposMusculares;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica.GruposMuscularesRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.GruposMuscularesServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GruposMuscularesServicoImplementacao implements GruposMuscularesServico {
  
    @Autowired
    private GruposMuscularesRepositorio gruposMuscularesRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public GruposMusculares salvarGruposMusculares(GruposMusculares gruposMusculares) {
        try {
            if (gruposMusculares.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(gruposMusculares
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + gruposMusculares.getPraticante().getIdPraticante() + "!"
                        ));
                if (!gruposMuscularesRepositorio.buscarGruposMuscularesPorChaveEstrangeira(gruposMusculares.getPraticante().getIdPraticante()).isPresent()) {

                    return gruposMuscularesRepositorio.save(gruposMusculares);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Essa grupos musculares já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a grupos musculares, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar a grupos musculares do praticante!");
        }
    }

    @Override
    public GruposMusculares atualizarGruposMusculares(GruposMusculares gruposMusculares) {
        try {
            if (gruposMusculares.getIdGruposMusculares() != null) {

                praticanteRepositorio.findById(gruposMusculares
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a grupos musculares!"));

                if (gruposMuscularesRepositorio.findById(gruposMusculares.getIdGruposMusculares()).isPresent()) {
                    return gruposMuscularesRepositorio.save(gruposMusculares);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de grupos musculares!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a grupos musculares, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public GruposMusculares buscarGruposMuscularesPorId(Long idGruposMusculares) {
        return gruposMuscularesRepositorio.buscarGruposMuscularesPorChaveEstrangeira(idGruposMusculares).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de grupos musculares!"));

    }
}
