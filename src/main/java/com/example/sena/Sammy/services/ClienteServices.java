package com.example.sena.Sammy.services;

import java.util.List;

import com.example.sena.Sammy.dtos.ClienteDto;
import com.example.sena.Sammy.dtos.ClienteDtoResponse;

public interface ClienteServices {

    //Registrar un nuevo cliente
    ClienteDtoResponse guardar(ClienteDto clienteDto);

    //Listar todos los clientes
    List<ClienteDtoResponse>listarTodos();

    //Consultar  cliente por Id
    ClienteDtoResponse buscarporId(Long id);

    //Actualizar Usuario
    ClienteDtoResponse actualizar(Long id, ClienteDto clienteDto);

    //Eliminar usuario
    ClienteDtoResponse eliminar(Long id, ClienteDto clienteDto);

}
