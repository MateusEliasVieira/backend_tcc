package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.impl;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.ResponsavelPraticante;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.ResponsavelPraticanteRepositorio;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.ResponsavelPraticanteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponsavelPraticanteServicoImplementacao implements ResponsavelPraticanteServico {

    @Autowired
    private ResponsavelPraticanteRepositorio repository;

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public ResponsavelPraticante salvar(ResponsavelPraticante responsavelPraticante) {
        praticanteRepositorio.findById(responsavelPraticante.getPraticante().getIdPraticante()).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum praticante com id " + responsavelPraticante.getPraticante().getIdPraticante() + "!"));

        if (buscarPorEmail(responsavelPraticante.getEmail()).isPresent()) {
            throw new ExcecaoDeRegrasDeNegocio("Já existe um responsável pelo paciente com o email " + responsavelPraticante.getEmail() + " para o praticante!");
        } else {
            return repository.save(responsavelPraticante);
        }
    }

    @Override
    public ResponsavelPraticante atualizar(ResponsavelPraticante responsavelPraticante) {
        praticanteRepositorio.findById(responsavelPraticante.getPraticante().getIdPraticante()).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum praticante com id "+ responsavelPraticante.getPraticante().getIdPraticante()+"!"));
        if(responsavelPraticante.getIdResponsavelPraticante() != null){
            Optional<ResponsavelPraticante> optional = repository.findById(responsavelPraticante.getIdResponsavelPraticante());
            if(optional.isPresent()){
                return repository.save(responsavelPraticante);
            }else{
                throw new ExcecaoDeRegrasDeNegocio("Não foi encontrado um responsável pelo praticante com id "+ responsavelPraticante.getIdResponsavelPraticante()+"!");
            }
        }else{
            throw new ExcecaoDeRegrasDeNegocio("O id do registro de emergência deve ser informado "+ responsavelPraticante.getIdResponsavelPraticante()+"!");
        }
    }

    @Override
    public ResponsavelPraticante buscarPorId(Long idResponsavelPraticante) {
        return repository.findById(idResponsavelPraticante).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum responsável pelo praticante com id "+idResponsavelPraticante));
    }

    @Override
    public Optional<ResponsavelPraticante> buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }
}
