package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.implementacao;
import com.equoterapia.dominio.excecaoDeDominio.ExcecaoDeRegrasDeNegocio;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.CoordenacaoMotora;
import com.equoterapia.dominio.repositorio.praticante.PraticanteRepositorio;
import com.equoterapia.dominio.repositorio.praticante.avaliacaoFisioterapeutica.CoordenacaoMotoraRepositorio;
import com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica.CoordenacaoMotoraServico;
import com.equoterapia.utilidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordenacaoMotoraServicoImplementacao implements CoordenacaoMotoraServico {
  
    @Autowired
    private CoordenacaoMotoraRepositorio coordenacaoMotoraRepositorio;
    @Autowired
    private PraticanteRepositorio praticanteRepositorio;

    @Override
    public CoordenacaoMotora salvarCoordenacaoMotora(CoordenacaoMotora coordenacaoMotora) {
        try {
            if (coordenacaoMotora.getPraticante().getIdPraticante() != null) {

                praticanteRepositorio.findById(coordenacaoMotora
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio(
                                Resposta.DADOS_PESSOAIS_NAO_CADASTRADOS
                                        + coordenacaoMotora.getPraticante().getIdPraticante() + "!"
                        ));
                if (!coordenacaoMotoraRepositorio.buscarCoordenacaoMotoraPorChaveEstrangeira(coordenacaoMotora.getPraticante().getIdPraticante()).isPresent()) {

                    return coordenacaoMotoraRepositorio.save(coordenacaoMotora);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Essa coordenação motora já foi cadastrada!");
                }

            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível salvar a coordenação motora, pois não foi possível identificar a qual praticante esse cadastro se refere!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Houve um erro ao salvar a coordenação motora do praticante!");
        }
    }

    @Override
    public CoordenacaoMotora atualizarCoordenacaoMotora(CoordenacaoMotora coordenacaoMotora) {
        try {
            if (coordenacaoMotora.getIdCoordenacaoMotora() != null) {

                praticanteRepositorio.findById(coordenacaoMotora
                                .getPraticante()
                                .getIdPraticante())
                        .orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o praticante referente a coordenação motora!"));

                if (coordenacaoMotoraRepositorio.findById(coordenacaoMotora.getIdCoordenacaoMotora()).isPresent()) {
                    return coordenacaoMotoraRepositorio.save(coordenacaoMotora);
                } else {
                    throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar, pois não existe o cadastro de coordenação motora!");
                }
            } else {
                throw new ExcecaoDeRegrasDeNegocio("Não foi possível atualizar a coordenação motora, pois não foi possível encontra-la!");
            }
        } catch (Exception e) {
            throw new ExcecaoDeRegrasDeNegocio("Não foi possível realizar a atualização do cadastro!");
        }
    }

    @Override
    public CoordenacaoMotora buscarCoordenacaoMotoraPorId(Long idCoordenacaoMotora) {
        return coordenacaoMotoraRepositorio.buscarCoordenacaoMotoraPorChaveEstrangeira(idCoordenacaoMotora).orElseThrow(() -> new ExcecaoDeRegrasDeNegocio("Não foi possível localizar o registro de coordenação motora!"));

    }
}
