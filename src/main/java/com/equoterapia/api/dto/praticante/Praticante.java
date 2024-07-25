package com.equoterapia.api.dto.praticante;

import com.equoterapia.api.dto.usuario.UsuarioEntradaDTO;
import com.equoterapia.dominio.modelo.praticante.avaliacaoFisioterapeutica.SaudeGeralDoPraticante;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Praticante {

    private Long idPraticante;
    private SaudeGeralDoPraticante saudeGeralDoPraticante;
    private UsuarioEntradaDTO usuarioEntradaDTO;

}
