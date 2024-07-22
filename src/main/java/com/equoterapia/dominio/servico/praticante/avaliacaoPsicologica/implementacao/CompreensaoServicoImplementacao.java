package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Compreensao;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica.CompreensaoRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.CompreensaoServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompreensaoServicoImplementacao implements CompreensaoServico {

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;
    @Autowired
    private CompreensaoRepositorio compreensaoRepositorio;

    @Override
    public Compreensao salvarCompreensao(Compreensao compreensao) {
        try {
            if (compreensao.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(compreensao
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + compreensao.getPraticante().getIdPraticante() + "!"
                        ));
                if (!compreensaoRepositorio.buscarCompreensaoPorChaveEstrangeira(compreensao.getPraticante().getIdPraticante()).isPresent()) {

                    return compreensaoRepositorio.save(compreensao);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Essa compreensão já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a compreensão, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar a compreensão do praticante!");
        }
    }

    @Override
    public Compreensao atualizarCompreensao(Compreensao compreensao) {
        try {
            if (compreensao.getIdCompreensao() != null) {

                praticanteRepositorio.findById(compreensao
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a compreensão!"));

                if (compreensaoRepositorio.findById(compreensao.getIdCompreensao()).isPresent()) {
                    return compreensaoRepositorio.save(compreensao);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de compreensão!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a compreensão, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public Compreensao buscarCompreensaoPorId(Long idCompreensao) {
        return compreensaoRepositorio.buscarCompreensaoPorChaveEstrangeira(idCompreensao).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de compreensão!"));
    }
}
