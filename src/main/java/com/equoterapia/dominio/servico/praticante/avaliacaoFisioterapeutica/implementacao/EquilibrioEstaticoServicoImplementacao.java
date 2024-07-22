package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.implementacao;
import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.EquilibrioEstatico;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica.EquilibrioEstaticoRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.EquilibrioEstaticoServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquilibrioEstaticoServicoImplementacao implements EquilibrioEstaticoServico {
  
    @Autowired
    private EquilibrioEstaticoRepositorio equilibrioEstaticoRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public EquilibrioEstatico salvarEquilibrioEstatico(EquilibrioEstatico equilibrioEstatico) {
        try {
            if (equilibrioEstatico.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(equilibrioEstatico
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + equilibrioEstatico.getPraticante().getIdPraticante() + "!"
                        ));
                if (!equilibrioEstaticoRepositorio.buscarEquilibrioEstaticoPorChaveEstrangeira(equilibrioEstatico.getPraticante().getIdPraticante()).isPresent()) {

                    return equilibrioEstaticoRepositorio.save(equilibrioEstatico);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Essa equilibrio estático já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a equilibrio estático, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar a equilibrio estático do praticante!");
        }
    }

    @Override
    public EquilibrioEstatico atualizarEquilibrioEstatico(EquilibrioEstatico equilibrioEstatico) {
        try {
            if (equilibrioEstatico.getIdEquilibrioEstatico() != null) {

                praticanteRepositorio.findById(equilibrioEstatico
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a equilibrio estático!"));

                if (equilibrioEstaticoRepositorio.findById(equilibrioEstatico.getIdEquilibrioEstatico()).isPresent()) {
                    return equilibrioEstaticoRepositorio.save(equilibrioEstatico);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de equilibrio estático!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a equilibrio estático, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public EquilibrioEstatico buscarEquilibrioEstaticoPorId(Long idEquilibrioEstatico) {
        return equilibrioEstaticoRepositorio.buscarEquilibrioEstaticoPorChaveEstrangeira(idEquilibrioEstatico).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de equilibrio estático!"));
    }
}
