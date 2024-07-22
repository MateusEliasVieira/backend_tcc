package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.SobreACrianca;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica.SobreACriancaRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.SobreACriancaServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SobreACriancaServicoImplementacao implements SobreACriancaServico {

    @Autowired
    private SobreACriancaRepositorio sobreACriancaRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public SobreACrianca salvarSobreACrianca(SobreACrianca sobreACrianca) {
        try {
            if (sobreACrianca.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(sobreACrianca
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + sobreACrianca.getPraticante().getIdPraticante() + "!"
                        ));
                if (!sobreACriancaRepositorio.buscarSobreACriancaPorChaveEstrangeira(sobreACrianca.getPraticante().getIdPraticante()).isPresent()) {

                    return sobreACriancaRepositorio.save(sobreACrianca);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Os dados sobre a criança já foram cadastrados!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a os dados sobre a criança, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar os dados sobre a criança!");
        }
    }

    @Override
    public SobreACrianca atualizarSobreACrianca(SobreACrianca sobreACrianca) {
        try {
            if (sobreACrianca.getIdSobreACrianca() != null) {

                praticanteRepositorio.findById(sobreACrianca
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente sobre a criança!"));

                if (sobreACriancaRepositorio.findById(sobreACrianca.getIdSobreACrianca()).isPresent()) {
                    return sobreACriancaRepositorio.save(sobreACrianca);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro sobre a criança!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar os dados sobre a criança, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public SobreACrianca buscarSobreACriancaPorId(Long idSobreACrianca) {
        return sobreACriancaRepositorio.buscarSobreACriancaPorChaveEstrangeira(idSobreACrianca).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro dos dados sobre a criança!"));

    }
}
