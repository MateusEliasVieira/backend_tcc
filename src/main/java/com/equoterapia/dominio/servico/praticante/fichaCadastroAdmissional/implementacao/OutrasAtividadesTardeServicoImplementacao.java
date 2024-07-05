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
        try {
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
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar os dados de outras atividades da tarde para o praticante!");
        }
    }

    @Override
    public OutrasAtividadesTarde atualizarOutrasAtividadesTarde(OutrasAtividadesTarde outrasAtividadesTarde) {
        try {
            if (outrasAtividadesTarde.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(outrasAtividadesTarde
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a outras atividades da manhã!"));

                if (outrasAtividadesTardeRepositorio.findById(outrasAtividadesTarde.getIdOutrasAtividadesTarde()).isPresent()) {
                    return outrasAtividadesTardeRepositorio.save(outrasAtividadesTarde);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar as outras atividades de manhã do praticante, pois ainda não foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public OutrasAtividadesTarde buscarOutrasAtividadesTardePorId(Long id) {
        return outrasAtividadesTardeRepositorio.findById(id).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Outras atividades da tarde do praticante não encontrada!"));
    }
}
