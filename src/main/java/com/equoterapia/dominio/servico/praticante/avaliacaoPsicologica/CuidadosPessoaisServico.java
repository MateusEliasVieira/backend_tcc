package com.equoterapia.dominio.servico.praticante.avaliacaoPsicologica;

import com.equoterapia.dominio.modelo.praticante.avaliacaoPsicologica.CuidadosPessoais;

public interface CuidadosPessoaisServico {

    public CuidadosPessoais salvarCuidadosPessoais(CuidadosPessoais cuidadosPessoais);
    public CuidadosPessoais atualizarCuidadosPessoais(CuidadosPessoais cuidadosPessoais);
    public CuidadosPessoais buscarCuidadosPessoaisPorId(Long idCuidadosPessoais);
}
