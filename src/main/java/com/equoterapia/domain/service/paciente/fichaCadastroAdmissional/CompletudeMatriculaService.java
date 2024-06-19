package com.equoterapia.domain.service.paciente.fichaCadastroAdmissional;

import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.CompletudeMatricula;

import java.util.Optional;

public interface CompletudeMatriculaService {

    public CompletudeMatricula salvarCompletudeMatricula(CompletudeMatricula completudeMatricula);
    public CompletudeMatricula atualizarCompletudeMatricula(CompletudeMatricula completudeMatricula);
    public CompletudeMatricula buscarCompletudeMatricula(Long idCompletudeMatricula);

}
