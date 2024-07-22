package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.HabilidadesSociais;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoPsicologica.HabilidadesSociaisRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica.HabilidadesSociaisServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadesSociaisServicoImplementacao implements HabilidadesSociaisServico {

    @Autowired
    private HabilidadesSociaisRepositorio habilidadesSociaisRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public HabilidadesSociais salvarHabilidadesSociais(HabilidadesSociais habilidadesSociais) {
        try {
            if (habilidadesSociais.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(habilidadesSociais
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + habilidadesSociais.getPraticante().getIdPraticante() + "!"
                        ));
                if (!habilidadesSociaisRepositorio.buscarHabilidadesSociaisPorChaveEstrangeira(habilidadesSociais.getPraticante().getIdPraticante()).isPresent()) {

                    return habilidadesSociaisRepositorio.save(habilidadesSociais);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("As habilidades sociais já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar as habilidades sociais, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar as habilidades sociais do praticante!");
        }
    }

    @Override
    public HabilidadesSociais atualizarHabilidadesSociais(HabilidadesSociais habilidadesSociais) {
        try {
            if (habilidadesSociais.getIdHabilidadesSociais() != null) {

                praticanteRepositorio.findById(habilidadesSociais
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente as habilidades sociais!"));

                if (habilidadesSociaisRepositorio.findById(habilidadesSociais.getIdHabilidadesSociais()).isPresent()) {
                    return habilidadesSociaisRepositorio.save(habilidadesSociais);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de habilidades sociais!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar as habilidades sociais, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public HabilidadesSociais buscarHabilidadesSociaisPorId(Long idHabilidadesSociais) {
        return habilidadesSociaisRepositorio.buscarHabilidadesSociaisPorChaveEstrangeira(idHabilidadesSociais).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de habilidades sociais!"));

    }
}
