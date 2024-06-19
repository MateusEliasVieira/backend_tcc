package com.equoterapia.api.mapper.usuario;

import com.equoterapia.api.dto.usuario.UsuarioInputDTO;
import com.equoterapia.api.dto.usuario.UsuarioOutputDTO;
import com.equoterapia.api.dto.usuario.UsuarioUpdateInputDTO;
import com.equoterapia.domain.model.usuario.Usuario;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {

    public static Usuario converterUsuarioInputDTOEmUsuario(UsuarioInputDTO usuarioInputDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuarioInputDTO, Usuario.class);
    }

    public static Usuario converterUsuarioUpdateInputDTOEmUsuario(UsuarioUpdateInputDTO usuarioUpdateInputDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuarioUpdateInputDTO, Usuario.class);
    }

    public static UsuarioOutputDTO converterUsuarioEmUsuarioOutputDTO(Usuario usuario){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuario, UsuarioOutputDTO.class);
    }

    public static List<UsuarioOutputDTO> converterListaUsuarioEmListaUsuarioOutputDTO(List<Usuario> listaUsuario){
        ModelMapper modelMapper = new ModelMapper();
        List<UsuarioOutputDTO> listaUsuarioOutputDTO = new ArrayList<>();
        for(Usuario usuario:listaUsuario){
            UsuarioOutputDTO usuarioOutputDTO = modelMapper.map(usuario,UsuarioOutputDTO.class);
            listaUsuarioOutputDTO.add(usuarioOutputDTO);
        }
        return listaUsuarioOutputDTO;
    }
}
