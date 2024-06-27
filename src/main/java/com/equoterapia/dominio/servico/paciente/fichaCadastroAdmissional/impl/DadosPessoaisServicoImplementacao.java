package com.equoterapia.dominio.servico.paciente.fichaCadastroAdmissional.impl;


import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.DadosPessoais;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.DadosPessoaisRepositorio;
import com.equoterapia.dominio.servico.paciente.fichaCadastroAdmissional.DadosPessoaisServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DadosPessoaisServicoImplementacao implements DadosPessoaisServico {

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Autowired
    private DadosPessoaisRepositorio dadosPessoaisRepositorio;

    @Override
    public DadosPessoais salvarDadosPessoais(DadosPessoais dadosPessoais) {
        if (dadosPessoaisRepositorio.findByCpf(dadosPessoais.getCpf()).isPresent()) {
            throw new ExcecaoDeRegrasDeNegocio("O praticante com CPF " + dadosPessoais.getCpf() + " já está cadastrado no sistema.");
        }else if(dadosPessoaisRepositorio.findByCartaoSUS(dadosPessoais.getCartaoSUS()).isPresent()){
            throw new ExcecaoDeRegrasDeNegocio("O praticante com cartão SUS " + dadosPessoais.getCartaoSUS() + " já está cadastrado no sistema.");
        }
        else {
            Praticante paciente = new Praticante();
            paciente = praticanteRepositorio.save(paciente);
            dadosPessoais.setPraticante(paciente);
            return dadosPessoaisRepositorio.save(dadosPessoais);
        }
    }

    @Override
    public DadosPessoais atualizarDadosPessoais(DadosPessoais dadosPessoais) {
        praticanteRepositorio.findById(dadosPessoais.getPraticante().getIdPaciente()).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum praticante com id " + dadosPessoais.getPraticante().getIdPaciente() + "!"));
        Optional<DadosPessoais> dadosPessoaisExistente = dadosPessoaisRepositorio.findByCpf(dadosPessoais.getCpf());
        if (dadosPessoaisExistente.isPresent()) {
            dadosPessoais.setIdDadosPessoais(dadosPessoaisExistente.get().getIdDadosPessoais());
            return dadosPessoaisRepositorio.save(dadosPessoais);
        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não existe praticante com CPF " + dadosPessoais.getCpf() + " cadastrado no sistema.");
        }
    }

    @Override
    public DadosPessoais buscarDadosPessoaisPorID(Long id_paciente) {
        return dadosPessoaisRepositorio.findById(id_paciente).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Paciente não encontrado."));
    }

    @Override
    public List<DadosPessoais> buscarDadosPessoaisDosPacientes() {
        return dadosPessoaisRepositorio.findAll();
    }

}
