package com.example.sena.Sammy.mappers;

import com.example.sena.Sammy.dtos.ClienteDto;
import com.example.sena.Sammy.models.usuarios.Cliente;

public interface ClienteMapper {

    //de cliente a clienteDto
    ClienteDto toDto(Cliente cliente);

    // de clienteDto a cliente
    Cliente toEntidad(ClienteDto clienteDto);


}
