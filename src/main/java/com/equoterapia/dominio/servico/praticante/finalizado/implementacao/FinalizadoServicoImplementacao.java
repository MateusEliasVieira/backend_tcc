package com.equoterapia.dominio.servico.praticante.finalizado.implementacao;

import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.Finalizado;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.finalizado.FinalizadoRepositorio;
import com.equoterapia.dominio.servico.praticante.finalizado.FinalizadoServico;
import org.springframework.stereotype.Service;

@Service
public class FinalizadoServicoImplementacao implements FinalizadoServico {


    private FinalizadoRepositorio repositorio;
    private PraticanteRepositorio praticanteRepositorio;


    @Override
    public Finalizado finalizarCadastro(Finalizado finalizado) {

        if (finalizado.getPraticante().getIdPraticante() == null)
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar o registro de finalização de cadastro do praticante!");

        praticanteRepositorio.findById(finalizado.getPraticante().getIdPraticante())
                .orElseThrow(() -> {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi encontrado o praticante para efetuar a conclusão do cadastro!");
                });

        return repositorio.save(finalizado);
    }

    @Override
    public Finalizado verificarStatusCadastro(Long idPraticante) {

        if (idPraticante == null)
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível consultar o status do cadastro do praticante!");

        praticanteRepositorio.findById(idPraticante)
                .orElseThrow(() -> {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi encontrado o praticante para realizar a consulta do status do seu cadastro!");
                });

        return repositorio.consultarStatusDeCadastroDoPraticante(idPraticante).orElseThrow(()->{
            throw new ExcecaoDeRegrasDeNegocio("Não foi encontrado nenhum praticante para realizar a consulta do status de cadastro!");
        });
    }
}
