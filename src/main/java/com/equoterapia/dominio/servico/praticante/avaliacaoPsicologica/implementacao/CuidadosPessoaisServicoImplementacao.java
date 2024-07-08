package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.CuidadosPessoais;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Rotina;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica.CuidadosPessoaisRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.CuidadosPessoaisServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuidadosPessoaisServicoImplementacao implements CuidadosPessoaisServico {

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;
    @Autowired
    private CuidadosPessoaisRepositorio cuidadosPessoaisRepositorio;

    @Override
    public CuidadosPessoais salvarCuidadosPessoais(CuidadosPessoais cuidadosPessoais) {
        try {
            if (cuidadosPessoais.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(cuidadosPessoais
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + cuidadosPessoais.getPraticante().getIdPraticante() + "!"
                        ));
                if (!cuidadosPessoaisRepositorio.buscarCuidadosPessoaisPorChaveEstrangeira(cuidadosPessoais.getPraticante().getIdPraticante()).isPresent()) {

                    return cuidadosPessoaisRepositorio.save(cuidadosPessoais);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Os cuidados pessoais já foi cadastrado!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar os cuidados pessoais, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar os cuidados pessoais do praticante!");
        }
    }

    @Override
    public CuidadosPessoais atualizarCuidadosPessoais(CuidadosPessoais cuidadosPessoais) {
        try {
            if (cuidadosPessoais.getIdCuidadosPessoais() != null) {

                praticanteRepositorio.findById(cuidadosPessoais
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente aos cuidados pessoais!"));

                if (cuidadosPessoaisRepositorio.findById(cuidadosPessoais.getIdCuidadosPessoais()).isPresent()) {
                    return cuidadosPessoaisRepositorio.save(cuidadosPessoais);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de cuidados pessoais!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar os cuidados pessoais, pois não foi possível encontra-lo!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public CuidadosPessoais buscarCuidadosPessoaisPorId(Long idCuidadosPessoais) {
        return cuidadosPessoaisRepositorio.findById(idCuidadosPessoais).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de cuidados pessoais!"));
    }

}
