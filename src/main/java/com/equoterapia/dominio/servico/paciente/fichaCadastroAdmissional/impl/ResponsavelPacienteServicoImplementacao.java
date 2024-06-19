package com.equoterapia.dominio.servico.paciente.fichaCadastroAdmissional.impl;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.ResponsavelPraticante;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.ResponsavelPraticanteRepositorio;
import com.equoterapia.dominio.servico.paciente.fichaCadastroAdmissional.ResponsavelPraticanteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponsavelPacienteServicoImplementacao implements ResponsavelPraticanteServico {

    @Autowired
    private ResponsavelPraticanteRepositorio repository;

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public ResponsavelPraticante salvar(ResponsavelPraticante responsavelPraticante) {
        praticanteRepositorio.findById(responsavelPraticante.getPaciente().getIdPaciente()).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum praticante com id " + responsavelPraticante.getPaciente().getIdPaciente() + "!"));

        if (buscarPorEmail(responsavelPraticante.getEmail()).isPresent()) {
            throw new ExcecaoDeRegrasDeNegocio("Já existe um responsável pelo paciente com o email " + responsavelPraticante.getEmail() + " para o praticante!");
        } else {
            return repository.save(responsavelPraticante);
        }
    }

    @Override
    public ResponsavelPraticante atualizar(ResponsavelPraticante responsavelPraticante) {
        praticanteRepositorio.findById(responsavelPraticante.getPaciente().getIdPaciente()).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum praticante com id "+ responsavelPraticante.getPaciente().getIdPaciente()+"!"));
        if(responsavelPraticante.getIdResponsavelPaciente() != null){
            Optional<ResponsavelPraticante> optional = repository.findById(responsavelPraticante.getIdResponsavelPaciente());
            if(optional.isPresent()){
                return repository.save(responsavelPraticante);
            }else{
                throw new ExcecaoDeRegrasDeNegocio("Não foi encontrado um responsável pelo praticante com id "+ responsavelPraticante.getIdResponsavelPaciente()+"!");
            }
        }else{
            throw new ExcecaoDeRegrasDeNegocio("O id do registro de emergência deve ser informado "+ responsavelPraticante.getIdResponsavelPaciente()+"!");
        }
    }

    @Override
    public ResponsavelPraticante buscarPorId(Long idResponsavelPaciente) {
        return repository.findById(idResponsavelPaciente).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum responsável pelo praticante com id "+idResponsavelPaciente));
    }

    @Override
    public Optional<ResponsavelPraticante> buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }
}
