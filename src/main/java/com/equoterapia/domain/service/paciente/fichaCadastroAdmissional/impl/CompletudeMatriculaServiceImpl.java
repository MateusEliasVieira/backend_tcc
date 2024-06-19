package com.equoterapia.domain.service.paciente.fichaCadastroAdmissional.impl;

import com.equoterapia.domain.domainException.RegrasDeNegocioException;
import com.equoterapia.domain.model.paciente.Paciente;
import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.CompletudeMatricula;
import com.equoterapia.domain.repository.paciente.PacienteRepository;
import com.equoterapia.domain.repository.paciente.fichaCadastroAdmissional.CompletudeMatriculaRepository;
import com.equoterapia.domain.service.paciente.fichaCadastroAdmissional.CompletudeMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompletudeMatriculaServiceImpl implements CompletudeMatriculaService {

    @Autowired
    private CompletudeMatriculaRepository completudeMatriculaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public CompletudeMatricula salvarCompletudeMatricula(CompletudeMatricula completudeMatricula) {
        Paciente pacienteEncontrado = pacienteRepository.findById(completudeMatricula.getPaciente().getIdPaciente()).orElseThrow(() -> new RegrasDeNegocioException("Não existe nenhum praticante com id "+completudeMatricula.getPaciente().getIdPaciente()+"!"));
        if(pacienteEncontrado.getCompletudeMatricula().getIdCompletudeMatricula() != null){
            // Já existe uma completude de matricula para esse paciente
            throw new RegrasDeNegocioException("Já existe uma completude de matricula para esse praticante!");
        }else{
            // não existe completude de matricula para esse paciente
            completudeMatricula.getPaciente().setIdPaciente(pacienteEncontrado.getIdPaciente());
            return completudeMatriculaRepository.save(completudeMatricula);
        }
    }

    @Override
    public CompletudeMatricula atualizarCompletudeMatricula(CompletudeMatricula completudeMatricula) {
        pacienteRepository.findById(completudeMatricula.getPaciente().getIdPaciente()).orElseThrow(() -> new RegrasDeNegocioException("Não existe nenhum praticante com id "+completudeMatricula.getPaciente().getIdPaciente()+"!"));
        if (completudeMatricula.getIdCompletudeMatricula() != null) { // foi passado o id
            Optional<CompletudeMatricula> completudeMatriculaExistente = completudeMatriculaRepository.findById(completudeMatricula.getIdCompletudeMatricula());
            if (completudeMatriculaExistente.isPresent()) { // existe um registro com esse id cadastrado
                return completudeMatriculaRepository.save(completudeMatricula);
            } else {
                throw new RegrasDeNegocioException("Não existe nenhum registro de completude de matrícula com esse id cadastrado na base de dados!");
            }
        } else {
            throw new RegrasDeNegocioException("É preciso do id para realizar a atualização da completude de matrícula!");
        }
    }

    @Override
    public CompletudeMatricula buscarCompletudeMatricula(Long idCompletudeMatricula) {
        return completudeMatriculaRepository.findById(idCompletudeMatricula).orElseThrow(() -> new RegrasDeNegocioException("Não existe nenhum registro de completude de matrícula com esse id cadastrado na base de dados!"));
    }
}
