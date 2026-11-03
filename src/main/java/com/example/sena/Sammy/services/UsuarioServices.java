package com.example.sena.Sammy.services;

import java.util.List;

import com.example.sena.Sammy.dtos.UsuarioDto;

public interface UsuarioServices {

    //registrar un nuevo usuario
    UsuarioDto guardar(UsuarioDto usuarioDto);

    //Listar todos los usuarios
    List<UsuarioDto> listarTodos();

    //consultar usuario por Id
    UsuarioDto buscarporId(Long id);

    //Actualizar usuario
    UsuarioDto actualizar(long id, UsuarioDto usuarioDto);

    //Eliminar un usuario
    UsuarioDto eliminar(long id, UsuarioDto usuarioDto);





}

