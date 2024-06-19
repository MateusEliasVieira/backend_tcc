package com.equoterapia.dominio.servico.paciente.fichaCadastroAdmissional;

import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.Emergencia;

public interface EmergenciaServico {

    public Emergencia salvarEmergencia(Emergencia emergencia);
    public Emergencia atualizarEmergencia(Emergencia emergencia);
    public Emergencia buscarEmergencia(Long id_emergencia);

}
