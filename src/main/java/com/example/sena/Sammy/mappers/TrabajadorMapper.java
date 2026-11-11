
package com.example.sena.Sammy.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.sena.Sammy.dtos.TrabajadorDto;
import com.example.sena.Sammy.dtos.TrabajadorDtoResponse;
import com.example.sena.Sammy.models.usuarios.Trabajador;

@Mapper(componentModel = "spring")
public interface TrabajadorMapper {

    // Convertir de DTO a Entidad
    @Mapping(source = "nomb", target = "nom")
    @Mapping(source = "apell", target = "ape")
    @Mapping(source = "direc", target = "dir")
    @Mapping(source = "tele", target = "tel")
    @Mapping (source = "sueldo", target = "sueldo")
    @Mapping(target = "cargo", ignore = true)
    Trabajador toEntidad(TrabajadorDto trabajadorDto);

    // Convertir de Entidad a DTO
    @Mapping(source = "nom", target = "nomb")
    @Mapping(source = "ape", target = "apell")
    @Mapping(source = "dir", target = "direc")
    @Mapping(source = "tel", target = "tele")
    @Mapping(source = "cargo.nom_TipoTrab", target = "cargo")
    TrabajadorDtoResponse toDtoResponse(Trabajador trabajador);

}


