package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.CompletudeMatricula;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.CompletudeMatriculaRepositorio;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.CompletudeMatriculaServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CompletudeMatriculaServicoImplementacao implements CompletudeMatriculaServico {

    @Autowired
    private CompletudeMatriculaRepositorio completudeMatriculaRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;


    public CompletudeMatricula salvarCompletudeMatricula(CompletudeMatricula completudeMatricula) {
        if (completudeMatricula.getPraticante().getIdPraticante() == null) {
            throw new ExcecaoDeRegrasDeNegocio("Praticante não identificado para salvar a completude de matrícula.");
        }

        praticanteRepositorio.findById(completudeMatricula.getPraticante().getIdPraticante())
                .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                        Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS + completudeMatricula.getPraticante().getIdPraticante() + "!"
                ));

        completudeMatriculaRepositorio.buscarCompletudeMatriculaPorChaveEstrangeira(completudeMatricula.getPraticante().getIdPraticante())
                .ifPresent(c -> {
                    throw new ExcecaoDeRegrasDeNegocio("Essa completude de matrícula já foi cadastrada!");
                });


        try {

            completudeMatricula.setFinalizado(true);

            return completudeMatriculaRepositorio.save(completudeMatricula);
        } catch (DataAccessException e) {
            throw new ExcecaoDeRegrasDeNegocio("Erro ao acessar o banco de dados ao salvar a completude de matrícula do praticante.");
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Erro inesperado ao salvar a completude de matrícula do praticante.");
        }
    }


    public CompletudeMatricula atualizarCompletudeMatricula(CompletudeMatricula completudeMatricula) {

        praticanteRepositorio.findById(completudeMatricula
                        .getPraticante()
                        .getIdPraticante())
                .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a completude de matrícula!"));

        if (completudeMatricula.getIdCompletudeMatricula() == null)
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a completude de matrícula, pois não foi possível encontra-la!");
        if (completudeMatriculaRepositorio.findById(completudeMatricula.getIdCompletudeMatricula()).isPresent()) {
            completudeMatricula.setFinalizado(true);
            return completudeMatriculaRepositorio.save(completudeMatricula);
        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de completude de matrícula!");
        }

    }


    public CompletudeMatricula buscarCompletudeMatricula(Long idCompletudeMatricula) {
        return completudeMatriculaRepositorio.buscarCompletudeMatriculaPorChaveEstrangeira(idCompletudeMatricula).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Completude de matrícula do praticante não encontrado!"));
    }
}
