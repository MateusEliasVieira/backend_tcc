package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.FichaCadastroAdmissional;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.FichaCadastroAdmissionalRepositorio;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.FichaCadastroAdmissionalServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FichaCadastroAdmissionalServicoImplementacao implements FichaCadastroAdmissionalServico {

    @Autowired
    private FichaCadastroAdmissionalRepositorio fichaCadastroAdmissionalRepositorio;

    @Override
    public FichaCadastroAdmissional salvarFichaCadastroAdmissional(FichaCadastroAdmissional fichaCadastroAdmissional) {
        try {
            return fichaCadastroAdmissionalRepositorio.save(fichaCadastroAdmissional);
        }catch (Exception e){
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a data de cadastro da ficha de cadastro admissional!");
        }
    }

    @Override
    public FichaCadastroAdmissional buscarFichaCadastroAdmissionalPorId(long idFichaCadastroAdmissional) {
        return fichaCadastroAdmissionalRepositorio.buscarFichaCadastroAdmissionalPorChaveEstrangeira(idFichaCadastroAdmissional).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi encontrado a data de cadastro da ficha de cadastro admissional!"));
    }
}
