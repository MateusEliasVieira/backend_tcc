package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.FichaCadastroAdmissional;

public interface FichaCadastroAdmissionalServico {

    public FichaCadastroAdmissional salvarFichaCadastroAdmissional(FichaCadastroAdmissional fichaCadastroAdmissional);
    public FichaCadastroAdmissional buscarFichaCadastroAdmissionalPorId(long idFichaCadastroAdmissional);

}
