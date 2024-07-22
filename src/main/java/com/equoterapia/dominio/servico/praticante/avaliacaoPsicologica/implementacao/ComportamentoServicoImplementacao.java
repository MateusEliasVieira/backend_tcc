package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Comportamento;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica.ComportamentoRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.ComportamentoServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComportamentoServicoImplementacao implements ComportamentoServico {

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;
    @Autowired
    private ComportamentoRepositorio comportamentoRepositorio;

    @Override
    public Comportamento salvarComportamento(Comportamento comportamento) {
        try {
            if (comportamento.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(comportamento
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + comportamento.getPraticante().getIdPraticante() + "!"
                        ));
                if (!comportamentoRepositorio.buscarComportamentoPorChaveEstrangeira(comportamento.getPraticante().getIdPraticante()).isPresent()) {

                    return comportamentoRepositorio.save(comportamento);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Essa comportamento já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a comportamento, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar a comportamento do praticante!");
        }
    }

    @Override
    public Comportamento atualizarComportamento(Comportamento comportamento) {
        try {
            if (comportamento.getIdComportamento() != null) {

                praticanteRepositorio.findById(comportamento
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a comportamento!"));

                if (comportamentoRepositorio.findById(comportamento.getIdComportamento()).isPresent()) {
                    return comportamentoRepositorio.save(comportamento);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de comportamento!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a comportamento, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public Comportamento buscarComportamentoPorId(Long idComportamento) {
        return comportamentoRepositorio.buscarComportamentoPorChaveEstrangeira(idComportamento).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de comportamento!"));
    }
}
