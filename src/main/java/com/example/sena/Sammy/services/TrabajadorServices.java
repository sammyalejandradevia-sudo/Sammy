package com.example.sena.Sammy.services;

import java.util.List;

import com.example.sena.Sammy.dtos.TrabajadorDto;

public interface TrabajadorServices {

       //Registrar un nuevo cliente
    TrabajadorDto guardar(TrabajadorDto trabajadorDto);

    //Listar todos los clientes
    List<TrabajadorDto>listarTodos();

    //Consultar  cliente por Id
    TrabajadorDto buscarporId(Long id);

    //Actualizar Usuario
    TrabajadorDto actualizar(Long id, TrabajadorDto trabajadorDto);

    //Eliminar usuario
    TrabajadorDto eliminar(Long id, TrabajadorDto trabajadorDto);
}
