package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.QuadroAtual;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica.QuadroAtualRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.QuadroAtualServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuadroAtualServicoImplementacao implements QuadroAtualServico {
  
    @Autowired
    private QuadroAtualRepositorio quadroAtualRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public QuadroAtual salvarQuadroAtual(QuadroAtual quadroAtual) {
        try {
            if (quadroAtual.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(quadroAtual
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + quadroAtual.getPraticante().getIdPraticante() + "!"
                        ));
                if (!quadroAtualRepositorio.buscarQuadroAtualPorChaveEstrangeira(quadroAtual.getPraticante().getIdPraticante()).isPresent()) {

                    return quadroAtualRepositorio.save(quadroAtual);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Esse quadro atual já foi cadastrado!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a quadro atual, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar o quadro atual do praticante!");
        }
    }

    @Override
    public QuadroAtual atualizarQuadroAtual(QuadroAtual quadroAtual) {
        try {
            if (quadroAtual.getIdQuadroAtual() != null) {

                praticanteRepositorio.findById(quadroAtual
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente ao quadro atual!"));

                if (quadroAtualRepositorio.findById(quadroAtual.getIdQuadroAtual()).isPresent()) {
                    return quadroAtualRepositorio.save(quadroAtual);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de quadro atual!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar o quadro atual, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public QuadroAtual buscarQuadroAtualPorId(Long idQuadroAtual) {
        return quadroAtualRepositorio.findById(idQuadroAtual).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de quadro atual!"));

    }
}
