package com.equoterapia.domain.service.paciente.fichaCadastroAdmissional;


import com.equoterapia.domain.model.paciente.fichaCadastroAdmissional.DadosPessoais;

import java.util.List;


public interface DadosPessoaisService {

    DadosPessoais salvarDadosPessoais(DadosPessoais dadosPessoais);

    DadosPessoais atualizarDadosPessoais(DadosPessoais dadosPessoais);

    DadosPessoais buscarDadosPessoaisPorID(Long id_paciente);

    List<DadosPessoais> buscarDadosPessoaisDosPacientes();
}


