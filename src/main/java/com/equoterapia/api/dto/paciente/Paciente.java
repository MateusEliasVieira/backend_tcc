package com.equoterapia.api.dto.paciente;

import com.equoterapia.api.dto.paciente.avaliacaoFisioterapeutica.SaudeGeralDosPacientes;
import com.equoterapia.api.dto.usuario.UsuarioInputDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Paciente {

    private Long idPaciente;

    private SaudeGeralDosPacientes saudeGeralDosPacientes;

    private UsuarioInputDTO usuarioInputDTO;

}
