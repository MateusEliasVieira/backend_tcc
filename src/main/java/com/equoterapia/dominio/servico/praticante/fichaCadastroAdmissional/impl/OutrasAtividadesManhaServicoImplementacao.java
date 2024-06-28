package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.impl;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.OutrasAtividadesManha;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.OutrasAtividadesManhaRepositorio;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.OutrasAtividadesManhaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutrasAtividadesManhaServicoImplementacao implements OutrasAtividadesManhaServico {
    @Autowired
    private OutrasAtividadesManhaRepositorio repositorio;

    @Override
    public OutrasAtividadesManha salvarOutrasAtividadesManha(OutrasAtividadesManha outrasAtividadesManha) {
        if(!buscarOutrasAtividadesManhaPorId(outrasAtividadesManha.getIdOutrasAtividadesManha()).equals(null)){
            throw new ExcecaoDeRegrasDeNegocio("Já existe o cadastro de outras atividades de manha para o praticante!");
        }
        return repositorio.save(outrasAtividadesManha);
    }

    @Override
    public OutrasAtividadesManha atualizarOutrasAtividadesManha(OutrasAtividadesManha outrasAtividadesManha) {
        if(!buscarOutrasAtividadesManhaPorId(outrasAtividadesManha.getIdOutrasAtividadesManha()).equals(null)){
            return repositorio.save(outrasAtividadesManha);
        }
        throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar as outras atividades de manhã do praticante!");
    }

    @Override
    public OutrasAtividadesManha buscarOutrasAtividadesManhaPorId(Long id) {
        return repositorio.findById(id).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi encontrado outras atividades de manhã do praticante!"));
    }
}
