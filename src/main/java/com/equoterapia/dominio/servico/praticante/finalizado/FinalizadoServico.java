package com.equoterapia.dominio.servico.praticante.finalizado;

import com.equoterapia.dominio.modelo.praticante.Finalizado;

public interface FinalizadoServico {

    public Finalizado finalizarCadastro(Finalizado finalizado);
    public Finalizado verificarStatusCadastro(Long idPraticante);;

}
