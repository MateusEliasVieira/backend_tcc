package com.equoterapia.domain.service.paciente.fichaCadastroAdmissional.impl;

import com.equoterapia.domain.domainException.RegrasDeNegocioException;
import com.equoterapia.domain.model.paciente.Paciente;
import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.EducacaoPaciente;
import com.equoterapia.domain.repository.paciente.PacienteRepository;
import com.equoterapia.domain.repository.paciente.fichaCadastroAdmissional.EducacaoPacienteRepository;
import com.equoterapia.domain.service.paciente.fichaCadastroAdmissional.EducacaoPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

@Service
public class EducacaoPacienteServiceImpl implements EducacaoPacienteService {

    @Autowired
    private EducacaoPacienteRepository educacaoPacienteRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public EducacaoPaciente salvarEducacaoPaciente(EducacaoPaciente educacaoPaciente) {
        try {
            if(educacaoPaciente.getPaciente().getIdPaciente() != null) {
                // passou o id do paciente
                pacienteRepository.findById(
                        educacaoPaciente.getPaciente().getIdPaciente()).orElseThrow(
                        () -> new RegrasDeNegocioException("Não foi encontrado o praticante de id "
                                + educacaoPaciente.getPaciente().getIdPaciente() +
                                " vinculado a essa educação fornecida!"));


                return educacaoPacienteRepository.save(educacaoPaciente);

            } else {
                throw new RegrasDeNegocioException("É preciso informar o id do paciente, que é dono da educação informada!");
            }
            }catch (Exception e){
                throw new RegrasDeNegocioException("Houve um erro ao salvar os dados da educação para o devido praticante!");
            }
    }

    @Override
    public EducacaoPaciente atualizarEducacaoPaciente(EducacaoPaciente educacaoPaciente) {
        pacienteRepository.findById(educacaoPaciente.getPaciente().getIdPaciente()).orElseThrow(() -> new RegrasDeNegocioException("Não existe nenhum praticante com id "+educacaoPaciente.getPaciente().getIdPaciente()+"!"));
        Optional<EducacaoPaciente> educacaoPacienteExistente = educacaoPacienteRepository.findById(educacaoPaciente.getIdEducacaoPaciente());
        if (educacaoPacienteExistente.isPresent()) {
            educacaoPaciente.setIdEducacaoPaciente(educacaoPacienteExistente.get().getIdEducacaoPaciente());
            return educacaoPacienteRepository.save(educacaoPaciente);
        } else {
            throw new RegrasDeNegocioException("Não existe registros sobre a educação do praticante cadastrado no sistema!");
        }
    }

    @Override
    public EducacaoPaciente buscarEducacaoPaciente(Long idEducacaoPaciente) {
        return educacaoPacienteRepository.findById(idEducacaoPaciente).orElseThrow(() -> new RegrasDeNegocioException("Não foi encontrado a educação do paciente com id = " + idEducacaoPaciente + "!"));
    }

}
