package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Comportamento;

public interface ComportamentoServico {

    public Comportamento salvarComportamento(Comportamento comportamento);
    public Comportamento atualizarComportamento(Comportamento comportamento);
    public Comportamento buscarComportamentoPorId(Long idComportamento);
}
