package com.example.sena.Sammy.services;

import java.util.List;

import com.example.sena.Sammy.dtos.ClienteDto;

public interface ClieteServices {

    //Registrar un nuevo cliente
    ClienteDto guardar(ClienteDto clienteDto);

    //Listar todos los clientes
    List<ClienteDto>listarTodos();

    //Consultar  cliente por Id
    ClienteDto buscarporid(Long id);

    //Actualizar Usuario
    ClienteDto actualizar(Long id, ClienteDto clienteDto);

    //Eliminar usuario
    ClienteDto eliminar(Long id, ClienteDto clienteDto);

}
