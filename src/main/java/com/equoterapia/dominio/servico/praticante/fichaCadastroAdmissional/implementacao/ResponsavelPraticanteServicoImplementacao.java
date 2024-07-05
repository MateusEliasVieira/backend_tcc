package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.ResponsavelPraticante;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.ResponsavelPraticanteRepositorio;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.ResponsavelPraticanteServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponsavelPraticanteServicoImplementacao implements ResponsavelPraticanteServico {

    @Autowired
    private ResponsavelPraticanteRepositorio responsavelPraticanteRepositorio;

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public ResponsavelPraticante salvar(ResponsavelPraticante responsavelPraticante) {
        try {
            if (responsavelPraticante.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(responsavelPraticante
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS));

                if (!responsavelPraticanteRepositorio.buscarResponsavelPraticantePorChaveEstrangeira(responsavelPraticante.getPraticante().getIdPraticante()).isPresent()) {

                    if (responsavelPraticanteRepositorio.findByTelefoneTrabalho(responsavelPraticante.getTelefoneTrabalho()).isPresent()) {
                        throw new ExcecaoDeRegrasDeNegocio("Já existe um responsável do praticante com o telefone de trabalho "
                                + responsavelPraticante.getTelefoneTrabalho() + " cadastrado no sistema!");

                    } else if (responsavelPraticanteRepositorio.findByTelefone(responsavelPraticante.getTelefone()).isPresent()) {
                        throw new ExcecaoDeRegrasDeNegocio("Já existe um responsável do praticante com o telefone "
                                + responsavelPraticante.getTelefone() + " cadastrado no sistema!");

                    } else if (responsavelPraticanteRepositorio.findByEmail(responsavelPraticante.getEmail()).isPresent()) {
                        throw new ExcecaoDeRegrasDeNegocio("Já existe um responsável do praticante com o email "
                                + responsavelPraticante.getEmail() + " cadastrado no sistema!");

                    } else {
                        return responsavelPraticanteRepositorio.save(responsavelPraticante);
                    }
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Já foi cadastrado o responsável do praticante!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar os dados do responsável do praticante!");
        }

    }

    @Override
    public ResponsavelPraticante atualizar(ResponsavelPraticante responsavelPraticante) {
        try {
            if (responsavelPraticante.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(responsavelPraticante
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente ao responsável do praticante!"));

                if (responsavelPraticanteRepositorio.findById(responsavelPraticante.getIdResponsavelPraticante()).isPresent()) {
                    if (responsavelPraticanteRepositorio.findByTelefone(responsavelPraticante.getTelefone()).get().getIdResponsavelPraticante() != responsavelPraticante.getIdResponsavelPraticante()) {
                        // cadastros diferentes
                        throw new ExcecaoDeRegrasDeNegocio("Já existe outro registro que possui o telefone " + responsavelPraticante.getTelefone());
                    } else if (responsavelPraticanteRepositorio.findByTelefoneTrabalho(responsavelPraticante.getTelefoneTrabalho()).get().getIdResponsavelPraticante() != responsavelPraticante.getIdResponsavelPraticante()) {
                        // cadastros diferentes
                        throw new ExcecaoDeRegrasDeNegocio("Já existe outro registro que possui o telefone de trabalho " + responsavelPraticante.getTelefoneTrabalho());
                    } else if (responsavelPraticanteRepositorio.findByEmail(responsavelPraticante.getEmail()).get().getIdResponsavelPraticante() != responsavelPraticante.getIdResponsavelPraticante()) {
                        // cadastros diferentes
                        throw new ExcecaoDeRegrasDeNegocio("Já existe outro registro que possui o email " + responsavelPraticante.getEmail());
                    } else {
                        return responsavelPraticanteRepositorio.save(responsavelPraticante);
                    }
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe nenhum registro do responsável pelo praticante!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public ResponsavelPraticante buscarPorId(Long idResponsavelPraticante) {
        return responsavelPraticanteRepositorio.findById(idResponsavelPraticante).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Responsável do praticante não encontrado!!"));
    }

    @Override
    public Optional<ResponsavelPraticante> buscarPorEmail(String email) {
        return responsavelPraticanteRepositorio.findByEmail(email);
    }
}
