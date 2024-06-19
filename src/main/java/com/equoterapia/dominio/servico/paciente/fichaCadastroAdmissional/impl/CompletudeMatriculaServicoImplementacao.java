package com.equoterapia.dominio.servico.paciente.fichaCadastroAdmissional.impl;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.CompletudeMatricula;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.CompletudeMatriculaRepositorio;
import com.equoterapia.dominio.servico.paciente.fichaCadastroAdmissional.CompletudeMatriculaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompletudeMatriculaServicoImplementacao implements CompletudeMatriculaServico {

    @Autowired
    private CompletudeMatriculaRepositorio completudeMatriculaRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public CompletudeMatricula salvarCompletudeMatricula(CompletudeMatricula completudeMatricula) {
        Praticante pacienteEncontrado = praticanteRepositorio.findById(completudeMatricula.getPaciente().getIdPaciente()).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum praticante com id "+completudeMatricula.getPaciente().getIdPaciente()+"!"));
        if(pacienteEncontrado.getCompletudeMatricula().getIdCompletudeMatricula() != null){
            // Já existe uma completude de matricula para esse paciente
            throw new ExcecaoDeRegrasDeNegocio("Já existe uma completude de matricula para esse praticante!");
        }else{
            // não existe completude de matricula para esse paciente
            completudeMatricula.getPaciente().setIdPaciente(pacienteEncontrado.getIdPaciente());
            return completudeMatriculaRepositorio.save(completudeMatricula);
        }
    }

    @Override
    public CompletudeMatricula atualizarCompletudeMatricula(CompletudeMatricula completudeMatricula) {
        praticanteRepositorio.findById(completudeMatricula.getPaciente().getIdPaciente()).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum praticante com id "+completudeMatricula.getPaciente().getIdPaciente()+"!"));
        if (completudeMatricula.getIdCompletudeMatricula() != null) { // foi passado o id
            Optional<CompletudeMatricula> completudeMatriculaExistente = completudeMatriculaRepositorio.findById(completudeMatricula.getIdCompletudeMatricula());
            if (completudeMatriculaExistente.isPresent()) { // existe um registro com esse id cadastrado
                return completudeMatriculaRepositorio.save(completudeMatricula);
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não existe nenhum registro de completude de matrícula com esse id cadastrado na base de dados!");
            }
        } else {
            throw new ExcecaoDeRegrasDeNegocio("É preciso do id para realizar a atualização da completude de matrícula!");
        }
    }

    @Override
    public CompletudeMatricula buscarCompletudeMatricula(Long idCompletudeMatricula) {
        return completudeMatriculaRepositorio.findById(idCompletudeMatricula).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum registro de completude de matrícula com esse id cadastrado na base de dados!"));
    }
}
