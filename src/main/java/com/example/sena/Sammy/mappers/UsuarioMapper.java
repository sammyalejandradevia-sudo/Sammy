package com.example.sena.Sammy.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.sena.Sammy.dtos.UsuarioDto;
import com.example.sena.Sammy.models.usuarios.Usuario;

@Mapper (componentModel = "spring")
public  interface UsuarioMapper {



    //convertir de Entidad a Dto
    @Mapping(source = "nom", target = "nomb")
    @Mapping(source = "ape", target = "apell")
    @Mapping(source = "dir", target = "direc")
    @Mapping(source = "tel", target = "tele")
    UsuarioDto convierteDto(Usuario usuario);

      //convertir de Dto a Entidad
    @Mapping(source = "nomb", target = "nom")
    @Mapping(source = "apell", target = "ape")
    @Mapping(source = "direc", target = "dir")
    @Mapping(source = "tele", target = "tel")
    Usuario convertiraEntidad(UsuarioDto usuarioDto);



}
