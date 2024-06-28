package com.equoterapia.api.dto.praticante;

import com.equoterapia.api.dto.praticante.avaliacaoFisioterapeutica.SaudeGeralDosPraticantes;
import com.equoterapia.api.dto.usuario.UsuarioEntradaDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Praticante {

    private Long idPraticante;

    private SaudeGeralDosPraticantes saudeGeralDosPraticantes;

    private UsuarioEntradaDTO usuarioEntradaDTO;

}
