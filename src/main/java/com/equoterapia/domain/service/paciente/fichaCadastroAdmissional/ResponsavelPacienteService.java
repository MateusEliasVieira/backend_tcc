package com.equoterapia.domain.service.paciente.fichaCadastroAdmissional;

import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.ResponsavelPaciente;

import java.util.Optional;

public interface ResponsavelPacienteService {

    public ResponsavelPaciente salvar(ResponsavelPaciente responsavelPaciente);

    public ResponsavelPaciente atualizar(ResponsavelPaciente responsavelPaciente);
    public ResponsavelPaciente buscarPorId(Long idResponsavelPaciente);
    public Optional<ResponsavelPaciente> buscarPorEmail(String email);
}
