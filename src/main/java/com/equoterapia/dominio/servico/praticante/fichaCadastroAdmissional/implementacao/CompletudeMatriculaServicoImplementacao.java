package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.CompletudeMatricula;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.CompletudeMatriculaRepositorio;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.CompletudeMatriculaServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompletudeMatriculaServicoImplementacao implements CompletudeMatriculaServico {

    @Autowired
    private CompletudeMatriculaRepositorio completudeMatriculaRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;


    public CompletudeMatricula salvarCompletudeMatricula(CompletudeMatricula completudeMatricula) {
        try {
            if (completudeMatricula.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(completudeMatricula
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + completudeMatricula.getPraticante().getIdPraticante() + "!"
                        ));
                if (!completudeMatriculaRepositorio.buscarCompletudeMatriculaPorChaveEstrangeira(completudeMatricula.getPraticante().getIdPraticante()).isPresent()) {

                    return completudeMatriculaRepositorio.save(completudeMatricula);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Essa completude de matrícula já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a completude de matrícula, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar a completude de matrícula do praticante!");
        }
    }


    public CompletudeMatricula atualizarCompletudeMatricula(CompletudeMatricula completudeMatricula) {
        try {
            if (completudeMatricula.getIdCompletudeMatricula() != null) {

                praticanteRepositorio.findById(completudeMatricula
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a completude de matrícula!"));

                if (completudeMatriculaRepositorio.findById(completudeMatricula.getIdCompletudeMatricula()).isPresent()) {
                    return completudeMatriculaRepositorio.save(completudeMatricula);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de completude de matrícula!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a completude de matrícula, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }


    public CompletudeMatricula buscarCompletudeMatricula(Long idCompletudeMatricula) {
        return completudeMatriculaRepositorio.findById(idCompletudeMatricula).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Completude de matrícula do praticante não encontrado!"));
    }
}
