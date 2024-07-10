package com.equoterapia.dominio.servico.praticante.avaliacaoFisioterapeutica;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.CoordenacaoMotora;

public interface CoordenacaoMotoraServico {
    public CoordenacaoMotora salvarCoordenacaoMotora(CoordenacaoMotora coordenacaoMotora);

    public CoordenacaoMotora atualizarCoordenacaoMotora(CoordenacaoMotora coordenacaoMotora);

    public CoordenacaoMotora buscarCoordenacaoMotoraPorId(Long idCoordenacaoMotora);
}
