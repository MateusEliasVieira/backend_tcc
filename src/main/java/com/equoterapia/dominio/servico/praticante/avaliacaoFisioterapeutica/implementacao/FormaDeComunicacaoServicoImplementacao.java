package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.implementacao;
import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.FormaDeComunicacao;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica.FormaDeComunicacaoRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.FormaDeComunicacaoServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormaDeComunicacaoServicoImplementacao implements FormaDeComunicacaoServico {
  
    @Autowired
    private FormaDeComunicacaoRepositorio formaDeComunicacaoRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public FormaDeComunicacao salvarFormaDeComunicacao(FormaDeComunicacao formaDeComunicacao) {
        try {
            if (formaDeComunicacao.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(formaDeComunicacao
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + formaDeComunicacao.getPraticante().getIdPraticante() + "!"
                        ));
                if (!formaDeComunicacaoRepositorio.buscarFormaDeComunicacaoPorChaveEstrangeira(formaDeComunicacao.getPraticante().getIdPraticante()).isPresent()) {

                    return formaDeComunicacaoRepositorio.save(formaDeComunicacao);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Essa forma de comunicação já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a forma de comunicação, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar a forma de comunicação do praticante!");
        }
    }

    @Override
    public FormaDeComunicacao atualizarFormaDeComunicacao(FormaDeComunicacao formaDeComunicacao) {
        try {
            if (formaDeComunicacao.getIdFormaDeComunicacao() != null) {

                praticanteRepositorio.findById(formaDeComunicacao
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a forma de comunicação!"));

                if (formaDeComunicacaoRepositorio.findById(formaDeComunicacao.getIdFormaDeComunicacao()).isPresent()) {
                    return formaDeComunicacaoRepositorio.save(formaDeComunicacao);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de forma de comunicação!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a forma de comunicação, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public FormaDeComunicacao buscarFormaDeComunicacaoPorId(Long idFormaDeComunicacao) {
        return formaDeComunicacaoRepositorio.findById(idFormaDeComunicacao).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de forma de comunicação!"));

    }
}
