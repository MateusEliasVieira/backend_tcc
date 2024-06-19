package com.equoterapia.domain.service.paciente.fichaCadastroAdmissional.impl;


import com.equoterapia.domain.domainException.RegrasDeNegocioException;
import com.equoterapia.domain.model.paciente.Paciente;
import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.DadosPessoais;
import com.equoterapia.domain.repository.paciente.PacienteRepository;
import com.equoterapia.domain.repository.paciente.fichaCadastroAdmissional.DadosPessoaisRepository;
import com.equoterapia.domain.service.paciente.fichaCadastroAdmissional.DadosPessoaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DadosPessoaisServiceImpl implements DadosPessoaisService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DadosPessoaisRepository dadosPessoaisRepository;

    @Override
    public DadosPessoais salvarDadosPessoais(DadosPessoais dadosPessoais) {
        if (dadosPessoaisRepository.findByCpf(dadosPessoais.getCpf()).isPresent()) {
            throw new RegrasDeNegocioException("O praticante com CPF " + dadosPessoais.getCpf() + " já está cadastrado no sistema.");
        }else if(dadosPessoaisRepository.findByCartaoSUS(dadosPessoais.getCartaoSUS()).isPresent()){
            throw new RegrasDeNegocioException("O praticante com cartão SUS " + dadosPessoais.getCartaoSUS() + " já está cadastrado no sistema.");
        }
        else {
            Paciente paciente = new Paciente();
            paciente = pacienteRepository.save(paciente);
            dadosPessoais.setPaciente(paciente);
            return dadosPessoaisRepository.save(dadosPessoais);
        }
    }

    @Override
    public DadosPessoais atualizarDadosPessoais(DadosPessoais dadosPessoais) {
        pacienteRepository.findById(dadosPessoais.getPaciente().getIdPaciente()).orElseThrow(() -> new RegrasDeNegocioException("Não existe nenhum praticante com id " + dadosPessoais.getPaciente().getIdPaciente() + "!"));
        Optional<DadosPessoais> dadosPessoaisExistente = dadosPessoaisRepository.findByCpf(dadosPessoais.getCpf());
        if (dadosPessoaisExistente.isPresent()) {
            dadosPessoais.setIdDadosPessoais(dadosPessoaisExistente.get().getIdDadosPessoais());
            return dadosPessoaisRepository.save(dadosPessoais);
        } else {
            throw new RegrasDeNegocioException("Não existe praticante com CPF " + dadosPessoais.getCpf() + " cadastrado no sistema.");
        }
    }

    @Override
    public DadosPessoais buscarDadosPessoaisPorID(Long id_paciente) {
        return dadosPessoaisRepository.findById(id_paciente).orElseThrow(() -> new RegrasDeNegocioException("Paciente não encontrado."));
    }

    @Override
    public List<DadosPessoais> buscarDadosPessoaisDosPacientes() {
        return dadosPessoaisRepository.findAll();
    }

}
