package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.OutrasAtividadesManha;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.OutrasAtividadesManhaRepositorio;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.OutrasAtividadesManhaServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutrasAtividadesManhaServicoImplementacao implements OutrasAtividadesManhaServico {

    @Autowired
    private OutrasAtividadesManhaRepositorio outrasAtividadesManhaRepositorio;

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public OutrasAtividadesManha salvarOutrasAtividadesManha(OutrasAtividadesManha outrasAtividadesManha) {

        if (outrasAtividadesManha.getPraticante().getIdPraticante() != null) {

            praticanteRepositorio.findById(outrasAtividadesManha
                            .getPraticante()
                            .getIdPraticante())
                    .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS));

            if (!outrasAtividadesManhaRepositorio.buscarOutrasAtividadesManhaPorChaveEstrangeira(outrasAtividadesManha.getPraticante().getIdPraticante()).isPresent()) {
                return outrasAtividadesManhaRepositorio.save(outrasAtividadesManha);

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Já foi cadastrado outras atividades da manhã para o praticante!");
            }
        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível identificar a qual praticante esse cadastro se refere!");
        }


    }


    @Override
    public OutrasAtividadesManha atualizarOutrasAtividadesManha(OutrasAtividadesManha outrasAtividadesManha) {

        if (outrasAtividadesManha.getIdOutrasAtividadesManha() == null)
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar as outras atividdades da manhã do praticante, pois não foi possível encontra-la!");

        praticanteRepositorio.findById(outrasAtividadesManha
                        .getPraticante()
                        .getIdPraticante())
                .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a outras atividades da manhã!"));

        if (outrasAtividadesManhaRepositorio.findById(outrasAtividadesManha.getIdOutrasAtividadesManha()).isPresent()) {
            return outrasAtividadesManhaRepositorio.save(outrasAtividadesManha);
        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar as outras atividades de manhã do praticante, pois ainda não foi cadastrada!");
        }

    }

    @Override
    public OutrasAtividadesManha buscarOutrasAtividadesManhaPorId(Long id) {
        return outrasAtividadesManhaRepositorio.buscarOutrasAtividadesManhaPorChaveEstrangeira(id).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Outras atividades da manhã do praticante não encontrada!"));
    }
}
