package com.example.sena.Sammy.services;

import java.util.List;

import com.example.sena.Sammy.dtos.ClienteDto;

public interface ClienteServices {

    //Registrar un nuevo cliente
    ClienteDto guardar(ClienteDto clienteDto);

    //Listar todos los clientes
    List<ClienteDto>listarTodos();

    //Consultar  cliente por Id
    ClienteDto buscarporId(Long id);

    //Actualizar Usuario
    ClienteDto actualizar(Long id, ClienteDto clienteDto);

    //Eliminar usuario
    ClienteDto eliminar(Long id, ClienteDto clienteDto);

}
