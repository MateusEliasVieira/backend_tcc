package com.equoterapia.domain.service.paciente.fichaCadastroAdmissional;

import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.Emergencia;

public interface EmergenciaService {

    public Emergencia salvarEmergencia(Emergencia emergencia);
    public Emergencia atualizarEmergencia(Emergencia emergencia);
    public Emergencia buscarEmergencia(Long id_emergencia);

}
