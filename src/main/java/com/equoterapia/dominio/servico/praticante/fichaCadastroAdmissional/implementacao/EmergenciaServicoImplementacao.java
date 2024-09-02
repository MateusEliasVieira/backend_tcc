package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.Emergencia;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.EmergenciaRepositorio;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.EmergenciaServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmergenciaServicoImplementacao implements EmergenciaServico {

    @Autowired
    private EmergenciaRepositorio emergenciaRepositorio;

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public Emergencia salvarEmergencia(Emergencia emergencia) {

        if (emergencia.getPraticante().getIdPraticante() != null) {

            praticanteRepositorio.findById(emergencia
                            .getPraticante()
                            .getIdPraticante())
                    .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS));

            if (!emergenciaRepositorio.buscarEmergenciaPorChaveEstrangeira(emergencia.getPraticante().getIdPraticante()).isPresent()) {
                if (emergencia.getTelefone() != null) {
                    if (emergenciaRepositorio.findByTelefone(emergencia.getTelefone()).isPresent()) {
                        throw new ExcecaoDeRegrasDeNegocio("Já existe um registro de emergência com esse telefone "
                                + emergencia.getTelefone() + " para o praticante!");

                    } else {
                        emergencia.setFinalizado(true);
                        return emergenciaRepositorio.save(emergencia);
                    }
                } else {
                    emergencia.setFinalizado(true);
                    return emergenciaRepositorio.save(emergencia);
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Já foi cadastrado os dados de emergência do praticante!");
            }
        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível identificar a qual praticante esse cadastro se refere!");
        }

    }

    @Override
    public Emergencia atualizarEmergencia(Emergencia emergencia) { // id obrigatório

        if (emergencia.getPraticante().getIdPraticante() == null)
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível identificar a qual praticante esse cadastro se refere!");

        praticanteRepositorio.findById(emergencia
                        .getPraticante()
                        .getIdPraticante())
                .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a emergência!"));

        if (emergenciaRepositorio.findById(emergencia.getIdEmergencia()).isPresent()) {
            Optional<Emergencia> optional = emergenciaRepositorio.findByTelefone(emergencia.getTelefone());
            if (optional.isPresent() && optional.get().getIdEmergencia() != emergencia.getIdEmergencia()) {
                // cadastros diferentes
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar os dados de emergência do praticante, pois já existe um cadastro com o telefone " + emergencia.getTelefone() + "!");
            } else {
                emergencia.setFinalizado(true);
                return emergenciaRepositorio.save(emergencia);
            }
        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar os dados de emergência do praticante, pois ainda não foi cadastrado!");
        }

    }

    @Override
    public Emergencia buscarEmergencia(Long id_emergencia) {
        return emergenciaRepositorio.buscarEmergenciaPorChaveEstrangeira(id_emergencia).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Emergência do praticante não encontrada!"));
    }

}
