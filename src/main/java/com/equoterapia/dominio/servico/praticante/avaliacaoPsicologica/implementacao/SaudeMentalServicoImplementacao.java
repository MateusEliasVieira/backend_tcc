package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.SaudeMental;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica.SaudeMentalRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.SaudeMentalServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaudeMentalServicoImplementacao implements SaudeMentalServico {

    @Autowired
    private SaudeMentalRepositorio saudeMentalRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public SaudeMental salvarSaudeMental(SaudeMental saudeMental) {
        try {
            if (saudeMental.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(saudeMental
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + saudeMental.getPraticante().getIdPraticante() + "!"
                        ));
                if (!saudeMentalRepositorio.buscarSaudeMentalPorChaveEstrangeira(saudeMental.getPraticante().getIdPraticante()).isPresent()) {

                    return saudeMentalRepositorio.save(saudeMental);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Essa saúde mental já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a saúde mental, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar a saúde mental do praticante!");
        }
    }

    @Override
    public SaudeMental atualizarSaudeMental(SaudeMental saudeMental) {
        try {
            if (saudeMental.getIdSaudeMental() != null) {

                praticanteRepositorio.findById(saudeMental
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a saúde mental!"));

                if (saudeMentalRepositorio.findById(saudeMental.getIdSaudeMental()).isPresent()) {
                    return saudeMentalRepositorio.save(saudeMental);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de saúde mental!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a saúde mental, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public SaudeMental buscarSaudeMentalPorId(Long idSaudeMental) {
        return saudeMentalRepositorio.findById(idSaudeMental).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de saúde mental!"));

    }
}
