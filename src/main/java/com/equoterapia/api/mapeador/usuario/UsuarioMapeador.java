package com.equoterapia.api.mapeador.usuario;

import com.equoterapia.api.dto.usuario.UsuarioEntradaDTO;
import com.equoterapia.api.dto.usuario.UsuarioSaidaDTO;
import com.equoterapia.api.dto.usuario.UsuarioAtualizacaoEntradaDTO;
import com.equoterapia.dominio.modelo.usuario.Usuario;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapeador {

    public static Usuario converterUsuarioEntradaDTOEmUsuario(UsuarioEntradaDTO usuarioEntradaDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuarioEntradaDTO, Usuario.class);
    }

    public static Usuario converterUsuarioUpdateEntradaDTOEmUsuario(UsuarioAtualizacaoEntradaDTO usuarioAtualizacaoEntradaDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuarioAtualizacaoEntradaDTO, Usuario.class);
    }

    public static UsuarioSaidaDTO converterUsuarioEmUsuarioSaidaDTO(Usuario usuario){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuario, UsuarioSaidaDTO.class);
    }

    public static List<UsuarioSaidaDTO> converterListaUsuarioEmListaUsuarioSaidaDTO(List<Usuario> listaUsuario){
        ModelMapper modelMapper = new ModelMapper();
        List<UsuarioSaidaDTO> listaUsuarioSaidaDTO = new ArrayList<>();
        for(Usuario usuario:listaUsuario){
            UsuarioSaidaDTO usuarioSaidaDTO = modelMapper.map(usuario, UsuarioSaidaDTO.class);
            listaUsuarioSaidaDTO.add(usuarioSaidaDTO);
        }
        return listaUsuarioSaidaDTO;
    }
}
