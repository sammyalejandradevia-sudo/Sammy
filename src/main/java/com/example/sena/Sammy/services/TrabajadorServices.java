package com.example.sena.Sammy.services;

import java.util.List;
import com.example.sena.Sammy.dtos.TrabajadorDto;
import com.example.sena.Sammy.dtos.TrabajadorDtoResponse;

public interface TrabajadorServices {

       //Registrar un nuevo cliente
    TrabajadorDtoResponse guardar(TrabajadorDto trabajadorDto);

    List<TrabajadorDtoResponse>listarTodos();

    //Buscar por ID
    TrabajadorDtoResponse buscarporId(Long id);

    //Actualizar usuario
    TrabajadorDtoResponse actualizar(Long id, TrabajadorDto trabajadorDto);
    
    //Eliminar usuario
    TrabajadorDtoResponse eliminar(Long id, TrabajadorDto trabajadorDto);

}
