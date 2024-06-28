package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.impl;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.CompletudeMatricula;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.CompletudeMatriculaRepositorio;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.CompletudeMatriculaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompletudeMatriculaServicoImplementacao implements CompletudeMatriculaServico {

    @Autowired
    private CompletudeMatriculaRepositorio completudeMatriculaRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;


    public CompletudeMatricula salvarCompletudeMatricula(CompletudeMatricula completudeMatricula) {
        Praticante praticanteEncontrado = praticanteRepositorio.findById(completudeMatricula.getPraticante().getIdPraticante())
                .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum praticante com id " + completudeMatricula.getPraticante().getIdPraticante() + "!"));

        CompletudeMatricula completudeExistente = praticanteEncontrado.getCompletudeMatricula();
        if (completudeExistente != null && completudeExistente.getIdCompletudeMatricula() != null) {
            // Já existe uma completude de matricula para esse praticante
            throw new ExcecaoDeRegrasDeNegocio("Já existe uma completude de matricula para esse praticante!");
        } else {
            // Não existe completude de matricula para esse praticante
            completudeMatricula.getPraticante().setIdPraticante(praticanteEncontrado.getIdPraticante());
            return completudeMatriculaRepositorio.save(completudeMatricula);
        }
    }


    public CompletudeMatricula atualizarCompletudeMatricula(CompletudeMatricula completudeMatricula) {
        praticanteRepositorio.findById(completudeMatricula.getPraticante().getIdPraticante()).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum praticante com id " + completudeMatricula.getPraticante().getIdPraticante() + "!"));
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


    public CompletudeMatricula buscarCompletudeMatricula(Long idCompletudeMatricula) {
        return completudeMatriculaRepositorio.findById(idCompletudeMatricula).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum registro de completude de matrícula com esse id cadastrado na base de dados!"));
    }
}
