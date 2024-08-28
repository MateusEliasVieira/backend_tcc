package com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.implementacao;


import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.Praticante;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.DadosPessoais;
import com.equoterapia.dominio.modelo.praticante.fichaCadastroAdmissional.FichaCadastroAdmissional;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.fichaCadastroAdmissional.DadosPessoaisRepositorio;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.DadosPessoaisServico;
import com.equoterapia.dominio.servico.praticante.fichaCadastroAdmissional.FichaCadastroAdmissionalServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class DadosPessoaisServicoImplementacao implements DadosPessoaisServico {

    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Autowired
    private DadosPessoaisRepositorio dadosPessoaisRepositorio;

    @Autowired
    private FichaCadastroAdmissionalServico fichaCadastroAdmissionalServico;

    @Override
    public DadosPessoais salvarDadosPessoais(DadosPessoais dadosPessoais) {

        if (dadosPessoais.getCartaoSUS().isEmpty()) {
            throw new ExcecaoDeRegrasDeNegocio("Informe o cartão do SUS!");
        }

        if (!dadosPessoais.getCpf().isEmpty() && dadosPessoaisRepositorio.findByCpf(dadosPessoais.getCpf()).isPresent()) {

            throw new ExcecaoDeRegrasDeNegocio("O praticante com CPF "
                    + dadosPessoais.getCpf() + " já está cadastrado no sistema!");

        } else if (dadosPessoaisRepositorio.findByCartaoSUS(dadosPessoais.getCartaoSUS()).isPresent()) {

            throw new ExcecaoDeRegrasDeNegocio("O praticante com cartão do SUS "
                    + dadosPessoais.getCartaoSUS()
                    + " já está cadastrado no sistema!");

        } else {
            Praticante praticante = new Praticante();

            praticante = praticanteRepositorio.save(praticante);
            dadosPessoais.setPraticante(praticante);
            FichaCadastroAdmissional fichaCadastroAdmissional = new FichaCadastroAdmissional();
            fichaCadastroAdmissional.setPraticante(praticante);
            fichaCadastroAdmissional.setDataAvaliacao(new Date());

            if (fichaCadastroAdmissionalServico.salvarFichaCadastroAdmissional(fichaCadastroAdmissional) != null) {
                return dadosPessoaisRepositorio.save(dadosPessoais);
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar os dados pessoais do praticante!");
            }
        }

    }

    @Override
    public DadosPessoais atualizarDadosPessoais(DadosPessoais dadosPessoais) {

        if (dadosPessoais.getIdDadosPessoais() == null)
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar os dados pessoais, pois não foi possível encontra-lo!");


        praticanteRepositorio.findById(dadosPessoais.getPraticante().getIdPraticante())
                .orElseThrow(()->{throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar os dados pessoais do praticante pois não foi possível identifica-lo!");});

        if (dadosPessoais.getCartaoSUS().isEmpty())
            throw new ExcecaoDeRegrasDeNegocio("Informe o cartão do SUS!");


        if (dadosPessoaisRepositorio.findById(dadosPessoais.getIdDadosPessoais()).isPresent()) {

            if (!dadosPessoais.getCpf().isEmpty() && dadosPessoaisRepositorio.findByCpf(dadosPessoais.getCpf()).isPresent()) {

                if (dadosPessoaisRepositorio.findByCpf(dadosPessoais.getCpf()).get().getIdDadosPessoais() != dadosPessoais.getIdDadosPessoais()) {
                    // cadastros diferentes
                    throw new ExcecaoDeRegrasDeNegocio("Já existe outro registro que possui o cpf " + dadosPessoais.getCpf());
                }

            } else if (dadosPessoaisRepositorio.findByCartaoSUS(dadosPessoais.getCartaoSUS()).isPresent()) {
                if (dadosPessoaisRepositorio.findByCartaoSUS(dadosPessoais.getCartaoSUS()).get().getIdDadosPessoais() != dadosPessoais.getIdDadosPessoais()) {
                    // cadastros diferentes
                    throw new ExcecaoDeRegrasDeNegocio("Já existe outro registro que possui o cartão do SUS " + dadosPessoais.getCartaoSUS());
                }
            }
        } else {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de dados pessoais!");
        }

        dadosPessoais.setFinalizado(true);

        return dadosPessoaisRepositorio.save(dadosPessoais);

    }

    @Override
    public DadosPessoais buscarDadosPessoaisPorID(Long idDadosPessoais) {
        return dadosPessoaisRepositorio.findById(idDadosPessoais).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Dados pessoais do praticante não encontrado!"));
    }

    @Override
    public DadosPessoais buscarDadosPessoaisPorIdDoPraticante(Long idPraticante) {
        return dadosPessoaisRepositorio.buscarDadosPessoaisPorIdDoPraticante(idPraticante).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Dados pessoais do praticante não encontrado!"));
    }

    @Override
    public DadosPessoais buscarDadosPessoaisPorCPF(String cpf) {
        return dadosPessoaisRepositorio.findByCpf(cpf).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não existe nenhum praticante cadastrado no sistema com o cpf " + cpf + " ou talvez o cpf não tenha sido informado no momento do cadastro do praticante!"));
    }

    @Override
    public List<DadosPessoais> buscarDadosPessoaisDosPraticantes() {
        return dadosPessoaisRepositorio.findAllByOrderByIdDadosPessoaisDesc().orElseThrow(()->{throw new ExcecaoDeRegrasDeNegocio("Nenhum registro encontrado no momento!");});
    }

    @Override
    public List<DadosPessoais> buscarDadosPessoaisPorNome(String nome) {
        if (nome.isEmpty()) {
            return buscarDadosPessoaisDosPraticantes();
        }
        return dadosPessoaisRepositorio.findByNomeCompleto(nome);
    }

}
