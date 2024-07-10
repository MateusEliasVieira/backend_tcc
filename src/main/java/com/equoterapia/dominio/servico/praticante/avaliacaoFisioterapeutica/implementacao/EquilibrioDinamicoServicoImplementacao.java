package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.implementacao;
import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.EquilibrioDinamico;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica.EquilibrioDinamicoRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.EquilibrioDinamicoServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquilibrioDinamicoServicoImplementacao implements EquilibrioDinamicoServico {
  
    @Autowired
    private EquilibrioDinamicoRepositorio equilibrioDinamicoRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public EquilibrioDinamico salvarEquilibrioDinamico(EquilibrioDinamico equilibrioDinamico) {
        try {
            if (equilibrioDinamico.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(equilibrioDinamico
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + equilibrioDinamico.getPraticante().getIdPraticante() + "!"
                        ));
                if (!equilibrioDinamicoRepositorio.buscarEquilibrioDinamicoPorChaveEstrangeira(equilibrioDinamico.getPraticante().getIdPraticante()).isPresent()) {

                    return equilibrioDinamicoRepositorio.save(equilibrioDinamico);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Essa equilibrio dinamico já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a equilibrio dinamico, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar a equilibrio dinamico do praticante!");
        }
    }

    @Override
    public EquilibrioDinamico atualizarEquilibrioDinamico(EquilibrioDinamico equilibrioDinamico) {
        try {
            if (equilibrioDinamico.getIdEquilibrioDinamico() != null) {

                praticanteRepositorio.findById(equilibrioDinamico
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a equilibrio dinamico!"));

                if (equilibrioDinamicoRepositorio.findById(equilibrioDinamico.getIdEquilibrioDinamico()).isPresent()) {
                    return equilibrioDinamicoRepositorio.save(equilibrioDinamico);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de equilibrio dinamico!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a equilibrio dinamico, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public EquilibrioDinamico buscarEquilibrioDinamicoPorId(Long idEquilibrioDinamico) {
        return equilibrioDinamicoRepositorio.findById(idEquilibrioDinamico).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de equilibrio dinamico!"));
    }
}
