package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.MobilidadeArticular;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica.MobilidadeArticularRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.MobilidadeArticularServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobilidadeArticularServicoImplementacao implements MobilidadeArticularServico {
  
    @Autowired
    private MobilidadeArticularRepositorio mobilidadeArticularRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public MobilidadeArticular salvarMobilidadeArticular(MobilidadeArticular mobilidadeArticular) {
        try {
            if (mobilidadeArticular.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(mobilidadeArticular
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + mobilidadeArticular.getPraticante().getIdPraticante() + "!"
                        ));
                if (!mobilidadeArticularRepositorio.buscarMobilidadeArticularPorChaveEstrangeira(mobilidadeArticular.getPraticante().getIdPraticante()).isPresent()) {

                    return mobilidadeArticularRepositorio.save(mobilidadeArticular);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Essa mobilidade articular já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a mobilidade articular, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar a mobilidade articular do praticante!");
        }
    }

    @Override
    public MobilidadeArticular atualizarMobilidadeArticular(MobilidadeArticular mobilidadeArticular) {
        try {
            if (mobilidadeArticular.getIdMobilidadeArticular() != null) {

                praticanteRepositorio.findById(mobilidadeArticular
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a mobilidade articular!"));

                if (mobilidadeArticularRepositorio.findById(mobilidadeArticular.getIdMobilidadeArticular()).isPresent()) {
                    return mobilidadeArticularRepositorio.save(mobilidadeArticular);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de mobilidade articular!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a mobilidade articular, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public MobilidadeArticular buscarMobilidadeArticularPorId(Long idMobilidadeArticular) {
        return mobilidadeArticularRepositorio.findById(idMobilidadeArticular).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de mobilidade articular!"));

    }
}
