package com.example.sena.Sammy.servicesImplement;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sena.Sammy.dtos.UsuarioDto;
import com.example.sena.Sammy.mappers.UsuarioMapper;
import com.example.sena.Sammy.models.usuarios.Usuario;
import com.example.sena.Sammy.repositories.UsuarioRepository;
import com.example.sena.Sammy.services.UsuarioServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServicesImplemet implements UsuarioServices {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

   
    @Override
    public UsuarioDto guardar(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioMapper.convertiraEntidad(usuarioDto);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        return usuarioMapper.convierteDto(usuarioGuardado);
    }

    //Listar todos
    @Override 
    public List<UsuarioDto>listarTodos(){
        return usuarioRepository.findAll()
        .stream()
        .map(usuarioMapper::convierteDto)
        .toList();
    }

    //consultar usuario por id
    @Override 
    public  UsuarioDto buscarporId(Long id){
        Usuario usuario=usuarioRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("usuario no encontrado"+id)
    );
    return usuarioMapper.convierteDto(usuario);
    }

    //Actualizar usuario
    @Override 
    public UsuarioDto actualizar(long id, UsuarioDto usuarioDto){
        Usuario usuarioEncontrado = usuarioRepository.findById(id)
        .orElseThrow(() ->new EntityNotFoundException("No se encontro usuario con id,"+id));

        //Actualizar datos
        usuarioEncontrado.setNom(usuarioDto.getNomb());
        usuarioEncontrado.setApe(usuarioDto.getApell());
        usuarioEncontrado.setDir(usuarioDto.getDirec());
        usuarioEncontrado.setTel(usuarioDto.getTele());

        Usuario usuarioActualizado = usuarioRepository.save(usuarioEncontrado);
        return  usuarioMapper.convierteDto(usuarioActualizado);
    }

    //Eliminar datos
    @Override 
    public  UsuarioDto eliminar(long id, UsuarioDto usuarioDto){
        Usuario usuarioEliminado = usuarioRepository.findById(id)
        .orElseThrow(() ->new EntityNotFoundException("No se encontro usuario con id"+id));
         usuarioRepository.delete(usuarioEliminado);
        return  usuarioMapper.convierteDto(usuarioEliminado);
    }

}