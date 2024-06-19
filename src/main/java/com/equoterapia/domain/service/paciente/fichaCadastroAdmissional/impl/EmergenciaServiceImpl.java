package com.equoterapia.domain.service.paciente.fichaCadastroAdmissional.impl;

import com.equoterapia.domain.domainException.RegrasDeNegocioException;
import com.equoterapia.domain.model.paciente.Paciente;
import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.Emergencia;
import com.equoterapia.domain.repository.paciente.PacienteRepository;
import com.equoterapia.domain.repository.paciente.fichaCadastroAdmissional.EmergenciaRepository;
import com.equoterapia.domain.service.paciente.fichaCadastroAdmissional.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmergenciaServiceImpl implements EmergenciaService {

    @Autowired
    private EmergenciaRepository emergenciaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Emergencia salvarEmergencia(Emergencia emergencia) {
        pacienteRepository.findById(emergencia.getPaciente().getIdPaciente()).orElseThrow(() -> new RegrasDeNegocioException("Não existe nenhum praticante com id "+emergencia.getPaciente().getIdPaciente()+"!"));
        Optional<Emergencia> optional = emergenciaRepository.findByTelefone(emergencia.getTelefone());
        if(optional.isPresent()){
            throw new RegrasDeNegocioException("Já existe um registro de emergência com esse telefone "+emergencia.getTelefone()+" para o praticante!");
        }else{
            return emergenciaRepository.save(emergencia);
        }
    }

    @Override
    public Emergencia atualizarEmergencia(Emergencia emergencia) { // id obrigatório
        pacienteRepository.findById(emergencia.getPaciente().getIdPaciente()).orElseThrow(() -> new RegrasDeNegocioException("Não existe nenhum praticante com id "+emergencia.getPaciente().getIdPaciente()+"!"));
        if(emergencia.getIdEmergencia() != null){
            Optional<Emergencia> optional = emergenciaRepository.findById(emergencia.getIdEmergencia());
            if(optional.isPresent()){
                return emergenciaRepository.save(emergencia);
            }else{
                throw new RegrasDeNegocioException("Não foi encontrado um registro de emergência com id "+emergencia.getIdEmergencia()+"!");
            }
        }else{
            throw new RegrasDeNegocioException("O id do registro de emergência deve ser informado "+emergencia.getIdEmergencia()+"!");
        }
    }

    @Override
    public Emergencia buscarEmergencia(Long id_emergencia) {
        return emergenciaRepository.findById(id_emergencia).orElseThrow(()-> new RegrasDeNegocioException("Não foi encontrado um registro de emergência com id "+id_emergencia+"!"));
    }

}
