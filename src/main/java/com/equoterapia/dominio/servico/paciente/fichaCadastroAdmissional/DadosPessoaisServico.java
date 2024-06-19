package com.equoterapia.dominio.servico.paciente.fichaCadastroAdmissional;


import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.DadosPessoais;

import java.util.List;


public interface DadosPessoaisServico {

    DadosPessoais salvarDadosPessoais(DadosPessoais dadosPessoais);

    DadosPessoais atualizarDadosPessoais(DadosPessoais dadosPessoais);

    DadosPessoais buscarDadosPessoaisPorID(Long id_paciente);

    List<DadosPessoais> buscarDadosPessoaisDosPacientes();
}


