package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.impl;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.OutrasAtividadesTarde;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.OutrasAtividadesTardeRepositorio;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.OutrasAtividadesTardeServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutrasAtividadesTardeServicoImplementacao implements OutrasAtividadesTardeServico {
    @Autowired
    private OutrasAtividadesTardeRepositorio repositorio;

    @Override
    public OutrasAtividadesTarde salvarOutrasAtividadesTarde(OutrasAtividadesTarde outrasAtividadesTarde) {
        if(!buscarOutrasAtividadesTardePorId(outrasAtividadesTarde.getIdOutrasAtividadesTarde()).equals(null)){
            throw new ExcecaoDeRegrasDeNegocio("Já existe o cadastro de outras atividades de tarde para o praticante!");
        }
        return repositorio.save(outrasAtividadesTarde);
    }

    @Override
    public OutrasAtividadesTarde atualizarOutrasAtividadesTarde(OutrasAtividadesTarde outrasAtividadesTarde) {
        if(!buscarOutrasAtividadesTardePorId(outrasAtividadesTarde.getIdOutrasAtividadesTarde()).equals(null)){
            return repositorio.save(outrasAtividadesTarde);
        }
        throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar as outras atividades da tarde do praticante!");
    }

    @Override
    public OutrasAtividadesTarde buscarOutrasAtividadesTardePorId(Long id) {
        return repositorio.findById(id).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi encontrado outras atividades da tarde do praticante!"));
    }
}
