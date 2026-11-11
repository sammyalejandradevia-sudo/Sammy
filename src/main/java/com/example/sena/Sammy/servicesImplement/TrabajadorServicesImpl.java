package com.example.sena.Sammy.servicesImplement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sena.Sammy.dtos.ClienteDtoResponse;
import com.example.sena.Sammy.dtos.TrabajadorDto;
import com.example.sena.Sammy.dtos.TrabajadorDtoResponse;
import com.example.sena.Sammy.mappers.TrabajadorMapper;
import com.example.sena.Sammy.models.usuarios.Cliente;
import com.example.sena.Sammy.models.usuarios.TiposTrabajador;
import com.example.sena.Sammy.models.usuarios.Trabajador;
import com.example.sena.Sammy.repositories.TipoTrabajadorRepository;
import com.example.sena.Sammy.repositories.TrabajadorRepository;
import com.example.sena.Sammy.services.TrabajadorServices;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrabajadorServicesImpl implements TrabajadorServices{

    private final TrabajadorRepository trabajadorRepository;
    private final TrabajadorMapper trabajadorMapper;
    private final TipoTrabajadorRepository tiTrabRepo;

    @Override 
    public TrabajadorDtoResponse guardar(TrabajadorDto trabajadorDto){

        //1.buscar id de tipocliente a base de datos
        TiposTrabajador tipo = tiTrabRepo.findById(trabajadorDto.getCargo())
    .orElseThrow(() -> new EntityNotFoundException("tipo trabajador no encontrado con Id"));

        //2.Convierte Dto a Entidad
        Trabajador trabajador = trabajadorMapper.toEntidad(trabajadorDto);

        //3.El Id del cliente debe ser null por que es autoincrementable
        trabajador.setId(null);

        //4.Asigna tipocliente "id"
        trabajador.setCargo(tipo);

        //5.guarda cliente en base de datos
        Trabajador trabajadorGuardado = trabajadorRepository.save(trabajador);

        return trabajadorMapper.toDtoResponse(trabajadorGuardado);
    }
//Listar Todos
    @Override
    public List<TrabajadorDtoResponse> listarTodos() {
    return trabajadorRepository.findAll()
        .stream()
        .map(trabajadorMapper::toDtoResponse)
        .toList();
    }

    //Colsultar usuario por Id
    @Override 
    public TrabajadorDtoResponse buscarporId(Long id){
        Trabajador trabajador=trabajadorRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("Trabajador no encontrado con Id"+id));
        return  trabajadorMapper.toDtoResponse(trabajador);
    }

    //Actualizar Usuario
    @Override 
    public  TrabajadorDtoResponse actualizar(Long id, TrabajadorDto trabajadorDto){
        Trabajador trabajadorEncontrado = trabajadorRepository.findById(id)
        .orElseThrow(()->new EntityNotFoundException("No se encontro Trabajador con Id"+id));

        //Actualizar datos 
        trabajadorEncontrado.setNom(trabajadorDto.getNomb());
        trabajadorEncontrado.setApe(trabajadorDto.getApell());
        trabajadorEncontrado.setDir(trabajadorDto.getTele());
        trabajadorEncontrado.setTel(trabajadorDto.getTele());
    
        // Atributos propios del Trabajador
    trabajadorEncontrado.setSueldo(trabajadorDto.getSueldo());
    trabajadorEncontrado.setCargo(tiTrabRepo.findById(trabajadorDto.getCargo())
        .orElseThrow(() -> new EntityNotFoundException(
            "No se encontro tipo de trabajador " + trabajadorDto.getCargo() )));

    Trabajador trabajadorActualizado = trabajadorRepository.save(trabajadorEncontrado);

    return trabajadorMapper.toDtoResponse(trabajadorActualizado);
}

    //Eliminar Dato
    @Override 
    public  TrabajadorDtoResponse eliminar(Long id, TrabajadorDto trabajadorDto){
        Trabajador trabajadorEliminado = trabajadorRepository.findById(id)
        .orElseThrow(() ->new EntityNotFoundException("No se encontro usuario con id"+id));
        trabajadorRepository.delete(trabajadorEliminado);
        return  trabajadorMapper.toDtoResponse(trabajadorEliminado);
    }
}
