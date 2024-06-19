package com.equoterapia.domain.service.paciente.fichaCadastroAdmissional.impl;

import com.equoterapia.domain.domainException.RegrasDeNegocioException;
import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.ResponsavelPaciente;
import com.equoterapia.domain.repository.paciente.PacienteRepository;
import com.equoterapia.domain.repository.paciente.fichaCadastroAdmissional.ResponsavelPacienteRepository;
import com.equoterapia.domain.service.paciente.fichaCadastroAdmissional.ResponsavelPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponsavelPacienteServiceImpl implements ResponsavelPacienteService {

    @Autowired
    private ResponsavelPacienteRepository repository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public ResponsavelPaciente salvar(ResponsavelPaciente responsavelPaciente) {
        pacienteRepository.findById(responsavelPaciente.getPaciente().getIdPaciente()).orElseThrow(() -> new RegrasDeNegocioException("Não existe nenhum praticante com id " + responsavelPaciente.getPaciente().getIdPaciente() + "!"));

        if (buscarPorEmail(responsavelPaciente.getEmail()).isPresent()) {
            throw new RegrasDeNegocioException("Já existe um responsável pelo paciente com o email " + responsavelPaciente.getEmail() + " para o praticante!");
        } else {
            return repository.save(responsavelPaciente);
        }
    }

    @Override
    public ResponsavelPaciente atualizar(ResponsavelPaciente responsavelPaciente) {
        pacienteRepository.findById(responsavelPaciente.getPaciente().getIdPaciente()).orElseThrow(() -> new RegrasDeNegocioException("Não existe nenhum praticante com id "+responsavelPaciente.getPaciente().getIdPaciente()+"!"));
        if(responsavelPaciente.getIdResponsavelPaciente() != null){
            Optional<ResponsavelPaciente> optional = repository.findById(responsavelPaciente.getIdResponsavelPaciente());
            if(optional.isPresent()){
                return repository.save(responsavelPaciente);
            }else{
                throw new RegrasDeNegocioException("Não foi encontrado um responsável pelo praticante com id "+responsavelPaciente.getIdResponsavelPaciente()+"!");
            }
        }else{
            throw new RegrasDeNegocioException("O id do registro de emergência deve ser informado "+responsavelPaciente.getIdResponsavelPaciente()+"!");
        }
    }

    @Override
    public ResponsavelPaciente buscarPorId(Long idResponsavelPaciente) {
        return repository.findById(idResponsavelPaciente).orElseThrow(() -> new RegrasDeNegocioException("Não existe nenhum responsável pelo praticante com id "+idResponsavelPaciente));
    }

    @Override
    public Optional<ResponsavelPaciente> buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }
}
