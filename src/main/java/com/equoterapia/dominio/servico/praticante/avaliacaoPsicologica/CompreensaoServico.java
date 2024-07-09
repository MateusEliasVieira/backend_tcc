package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.Compreensao;

public interface CompreensaoServico {

    public Compreensao salvarCompreensao(Compreensao compreensao);
    public Compreensao atualizarCompreensao(Compreensao compreensao);
    public Compreensao buscarCompreensaoPorId(Long idCompreensao);
}
