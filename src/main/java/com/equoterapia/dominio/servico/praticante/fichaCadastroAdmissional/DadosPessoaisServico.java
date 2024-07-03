package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional;


import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.DadosPessoais;

import java.util.List;


public interface DadosPessoaisServico {

    DadosPessoais salvarDadosPessoais(DadosPessoais dadosPessoais);

    DadosPessoais atualizarDadosPessoais(DadosPessoais dadosPessoais);

    DadosPessoais buscarDadosPessoaisPorID(Long idDadosPessoais);

    List<DadosPessoais> buscarDadosPessoaisDosPraticantes();
}


