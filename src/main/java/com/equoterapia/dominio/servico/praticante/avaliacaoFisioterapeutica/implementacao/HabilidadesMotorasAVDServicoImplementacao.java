package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.HabilidadesMotorasAVD;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica.HabilidadesMotorasAVDRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.HabilidadesMotorasAVDServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadesMotorasAVDServicoImplementacao implements HabilidadesMotorasAVDServico {
  
    @Autowired
    private HabilidadesMotorasAVDRepositorio habilidadesMotorasAVDRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public HabilidadesMotorasAVD salvarHabilidadesMotorasAVD(HabilidadesMotorasAVD habilidadesMotorasAVD) {
        try {
            if (habilidadesMotorasAVD.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(habilidadesMotorasAVD
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + habilidadesMotorasAVD.getPraticante().getIdPraticante() + "!"
                        ));
                if (!habilidadesMotorasAVDRepositorio.buscarHabilidadesMotorasAVDPorChaveEstrangeira(habilidadesMotorasAVD.getPraticante().getIdPraticante()).isPresent()) {

                    return habilidadesMotorasAVDRepositorio.save(habilidadesMotorasAVD);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("As habilidades motoras AVD já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar as habilidades motoras AVD, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar as habilidades motoras AVD do praticante!");
        }
    }

    @Override
    public HabilidadesMotorasAVD atualizarHabilidadesMotorasAVD(HabilidadesMotorasAVD habilidadesMotorasAVD) {
        try {
            if (habilidadesMotorasAVD.getIdHabilidadesMotorasAVD() != null) {

                praticanteRepositorio.findById(habilidadesMotorasAVD
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente as habilidades motoras AVD!"));

                if (habilidadesMotorasAVDRepositorio.findById(habilidadesMotorasAVD.getIdHabilidadesMotorasAVD()).isPresent()) {
                    return habilidadesMotorasAVDRepositorio.save(habilidadesMotorasAVD);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de habilidades motoras AVD!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar as habilidades motoras AVD, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public HabilidadesMotorasAVD buscarHabilidadesMotorasAVDPorId(Long idHabilidadesMotorasAVD) {
        return habilidadesMotorasAVDRepositorio.buscarHabilidadesMotorasAVDPorChaveEstrangeira(idHabilidadesMotorasAVD).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de habilidades motoras AVD!"));

    }
}
