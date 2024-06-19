package com.equoterapia.dominio.servico.paciente.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.CompletudeMatricula;

public interface CompletudeMatriculaServico {

    public CompletudeMatricula salvarCompletudeMatricula(CompletudeMatricula completudeMatricula);
    public CompletudeMatricula atualizarCompletudeMatricula(CompletudeMatricula completudeMatricula);
    public CompletudeMatricula buscarCompletudeMatricula(Long idCompletudeMatricula);

}
