package com.example.sena.Sammy.servicesImplement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sena.Sammy.dtos.TrabajadorDto;
import com.example.sena.Sammy.dtos.UsuarioDto;
import com.example.sena.Sammy.mappers.TrabajadorMapper;
import com.example.sena.Sammy.mappers.UsuarioMapper;
import com.example.sena.Sammy.models.usuarios.Trabajador;
import com.example.sena.Sammy.models.usuarios.Usuario;
import com.example.sena.Sammy.repositories.TrabajadorRepository;
import com.example.sena.Sammy.repositories.UsuarioRepository;
import com.example.sena.Sammy.services.TrabajadorServices;
import com.example.sena.Sammy.services.UsuarioServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrabajadorServicesImpl implements TrabajadorServices{

     private final TrabajadorRepository trabajadorRepository;
    private final TrabajadorMapper trabajadorMapper;

   
    @Override
    public TrabajadorDto guardar(TrabajadorDto trabajadorDto) {
        Trabajador trabajador = trabajadorMapper.toEntidad(trabajadorDto);

      Trabajador trabajadorGuardado = trabajadorRepository.save(trabajador);

        return trabajadorMapper.toDto(trabajadorGuardado);
    }

    //Listar todos
    @Override 
    public List<TrabajadorDto>listarTodos(){
        return trabajadorRepository.findAll()
        .stream()
        .map(trabajadorMapper::toDto)
        .toList();
    }

    //consultar usuario por id
    @Override 
    public  TrabajadorDto buscarporId(Long id){
        Trabajador trabajador=trabajadorRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("Trabajador no encontrado"+id)
    );
    return trabajadorMapper.toDto(trabajador);
    }

    //Actualizar usuario
    @Override 
    public TrabajadorDto actualizar(Long id, TrabajadorDto trabajadorDto){
        Trabajador trabajadorEncontrado = trabajadorRepository.findById(id)
        .orElseThrow(() ->new EntityNotFoundException("No se encontro trabajador con id,"+id));

        //Actualizar datos
        trabajadorEncontrado.setNom(trabajadorDto.getNomb());
        trabajadorEncontrado.setApe(trabajadorDto.getApell());
        trabajadorEncontrado.setDir(trabajadorDto.getDirec());
        trabajadorEncontrado.setTel(trabajadorDto.getTele());
        trabajadorEncontrado.setCargo(trabajadorDto.getCargo());
        trabajadorEncontrado.setSueldo(trabajadorDto.getSueldo());

       Trabajador trabajadorActualizado = trabajadorRepository.save(trabajadorEncontrado);
        return  trabajadorMapper.toDto(trabajadorActualizado);
    }

    //Eliminar datos
    @Override 
    public  TrabajadorDto eliminar(Long id, TrabajadorDto trabajadorDto){
       Trabajador trabajadorEliminado = trabajadorRepository.findById(id)
        .orElseThrow(() ->new EntityNotFoundException("No se encontro trabajador con id"+id));
         trabajadorRepository.delete(trabajadorEliminado);
        return trabajadorMapper.toDto(trabajadorEliminado);
    }

}

