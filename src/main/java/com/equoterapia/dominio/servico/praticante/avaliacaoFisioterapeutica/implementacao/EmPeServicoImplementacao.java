package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.EmPe;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica.EmPeRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.EmPeServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmPeServicoImplementacao implements EmPeServico {
  
    @Autowired
    private EmPeRepositorio emPeRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public EmPe salvarEmPe(EmPe emPe) {
        try {
            if (emPe.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(emPe
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + emPe.getPraticante().getIdPraticante() + "!"
                        ));
                if (!emPeRepositorio.buscarEmPePorChaveEstrangeira(emPe.getPraticante().getIdPraticante()).isPresent()) {

                    return emPeRepositorio.save(emPe);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Em Pé já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar Em Pé, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar Em Pé do praticante!");
        }
    }

    @Override
    public EmPe atualizarEmPe(EmPe emPe) {
        try {
            if (emPe.getIdEmPe() != null) {

                praticanteRepositorio.findById(emPe
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a Em Pé!"));

                if (emPeRepositorio.findById(emPe.getIdEmPe()).isPresent()) {
                    return emPeRepositorio.save(emPe);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de Em Pé!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar Em Pé, pois não foi possível encontra-lo!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public EmPe buscarEmPePorId(Long idEmPe) {
        return emPeRepositorio.buscarEmPePorChaveEstrangeira(idEmPe).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de Em Pé!"));

    }
}
