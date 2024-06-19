package com.equoterapia.domain.service.paciente.fichaCadastroAdmissional;

import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.EducacaoPaciente;

public interface EducacaoPacienteService {

    public EducacaoPaciente salvarEducacaoPaciente(EducacaoPaciente educacaoPaciente);
    public EducacaoPaciente atualizarEducacaoPaciente(EducacaoPaciente educacaoPaciente);
    public EducacaoPaciente buscarEducacaoPaciente(Long idEducacaoPaciente);
}
