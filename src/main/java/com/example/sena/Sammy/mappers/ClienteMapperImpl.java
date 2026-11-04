package com.example.sena.Sammy.mappers;

import org.springframework.stereotype.Component;

import com.example.sena.Sammy.dtos.ClienteDto;
import com.example.sena.Sammy.models.usuarios.Cliente;

@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDto toDto(Cliente cliente){

        //validad que tenga datos
        if (cliente == null) {
            return  null;

        }

        //convertir de cliente a  clienteDto
        return  ClienteDto.builder()
        //atribitos de usuarioDto
        .id(cliente.getId())
        .nomb(cliente.getNom())
        .apell(cliente.getApe())
        .direc(cliente.getDir())
        .tele(cliente.getTel())

         //atributos de cliente
        .tipCli(cliente.getTipoCliente())
        .pts(cliente.getPuntos())
        .build();
    }

        @Override
        public Cliente toEntidad(ClienteDto clienteDto){

        //validad que tenga datos
        if (clienteDto == null) {
            return null;

        }

        return  Cliente.builder()
         //atributos de UsuarioDto
        .id(clienteDto.getId())
        .nom(clienteDto.getNomb())
        .ape(clienteDto.getApell())
        .dir(clienteDto.getDirec())
        .tel(clienteDto.getTele())

        .tipoCliente(clienteDto.getTipCli())
        .puntos(clienteDto.getPts())
        .build();

    }
}


