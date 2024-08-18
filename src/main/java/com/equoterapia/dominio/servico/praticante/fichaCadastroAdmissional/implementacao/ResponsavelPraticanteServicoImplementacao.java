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

        if (responsavelPraticante.getPraticante().getIdPraticante() == null) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível identificar a qual praticante esse cadastro se refere!");
        }

        praticanteRepositorio.findById(responsavelPraticante
                        .getPraticante()
                        .getIdPraticante())
                .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS));

        if (!responsavelPraticanteRepositorio.buscarResponsavelPraticantePorChaveEstrangeira(responsavelPraticante.getPraticante().getIdPraticante()).isPresent()) {

                return responsavelPraticanteRepositorio.save(responsavelPraticante);
        } else {
            throw new ExcecaoDeRegrasDeNegocio("Já foi cadastrado o responsável do praticante!");
        }
    }


    @Override
    public ResponsavelPraticante atualizar(ResponsavelPraticante responsavelPraticante) {

        if (responsavelPraticante.getPraticante().getIdPraticante() == null)
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível identificar a qual praticante esse cadastro se refere!");

        praticanteRepositorio.findById(responsavelPraticante
                        .getPraticante()
                        .getIdPraticante())
                .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente ao responsável do praticante!"));

        if (responsavelPraticanteRepositorio.findById(responsavelPraticante.getIdResponsavelPraticante()).isPresent()) {
            return responsavelPraticanteRepositorio.save(responsavelPraticante);
        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe nenhum registro do responsável pelo praticante!");
        }


    }

    @Override
    public ResponsavelPraticante buscarPorId(Long idResponsavelPraticante) {
        return responsavelPraticanteRepositorio.buscarResponsavelPraticantePorChaveEstrangeira(idResponsavelPraticante).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Responsável do praticante não encontrado!!"));
    }

    @Override
    public Optional<ResponsavelPraticante> buscarPorEmail(String email) {
        return responsavelPraticanteRepositorio.findByEmail(email);
    }
}
