package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.OutrasAtividadesTarde;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.OutrasAtividadesTardeRepositorio;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.OutrasAtividadesTardeServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutrasAtividadesTardeServicoImplementacao implements OutrasAtividadesTardeServico {
    @Autowired
    private OutrasAtividadesTardeRepositorio outrasAtividadesTardeRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public OutrasAtividadesTarde salvarOutrasAtividadesTarde(OutrasAtividadesTarde outrasAtividadesTarde) {

        if (outrasAtividadesTarde.getPraticante().getIdPraticante() != null) {

            praticanteRepositorio.findById(outrasAtividadesTarde
                            .getPraticante()
                            .getIdPraticante())
                    .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS));

            if (!outrasAtividadesTardeRepositorio.buscarOutrasAtividadesTardePorChaveEstrangeira(outrasAtividadesTarde.getPraticante().getIdPraticante()).isPresent()) {
                return outrasAtividadesTardeRepositorio.save(outrasAtividadesTarde);

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Já foi cadastrado outras atividades à tarde para o praticante!");
            }
        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível identificar a qual praticante esse cadastro se refere!");
        }

    }

    @Override
    public OutrasAtividadesTarde atualizarOutrasAtividadesTarde(OutrasAtividadesTarde outrasAtividadesTarde) {
        if (outrasAtividadesTarde.getIdOutrasAtividadesTarde() == null)
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar as atividades da tarde do praticante, pois não foi possível encontra-la!");

        praticanteRepositorio.findById(outrasAtividadesTarde
                        .getPraticante()
                        .getIdPraticante())
                .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a outras atividades da tarde!"));

        if (outrasAtividadesTardeRepositorio.findById(outrasAtividadesTarde.getIdOutrasAtividadesTarde()).isPresent()) {
            return outrasAtividadesTardeRepositorio.save(outrasAtividadesTarde);
        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar as outras atividades de tarde do praticante, pois ainda não foi cadastrada!");
        }
    }

    @Override
    public OutrasAtividadesTarde buscarOutrasAtividadesTardePorId(Long id) {
        return outrasAtividadesTardeRepositorio.buscarOutrasAtividadesTardePorChaveEstrangeira(id).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Outras atividades da tarde do praticante não encontrada!"));
    }

}
