package com.example.sena.Sammy.servicesImplement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sena.Sammy.dtos.ClienteDto;
import com.example.sena.Sammy.mappers.ClienteMapper;
import com.example.sena.Sammy.models.usuarios.Cliente;
import com.example.sena.Sammy.repositories.ClienteRepository;
import com.example.sena.Sammy.services.ClienteServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class ClienteServicesImpl implements ClienteServices{
    
    private final ClienteRepository clienteRepository;
    private  final ClienteMapper clienteMapper;

    @Override 
    public ClienteDto guardar(ClienteDto clienteDto){
        Cliente cliente = clienteMapper.toEntidad(clienteDto);

        Cliente clienteguardado = clienteRepository.save(cliente);

        return  clienteMapper.toDto(clienteguardado);
    }



    //Listar todos
    @Override 
    public List<ClienteDto>listarTodos(){
        return  clienteRepository.findAll()
        .stream()
        .map(clienteMapper::toDto)
        .toList();
    }

    //Consultar usuario por Id
    @Override 
    public ClienteDto buscarporId(Long id){
        Cliente cliente=clienteRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("cliente no encontrado"+id));
        return  clienteMapper.toDto(cliente);
    }

    //Actualizar usuario
      @Override 
    public ClienteDto actualizar(Long id, ClienteDto clienteDto){
        Cliente clienteEncontrado = clienteRepository.findById(id)
        .orElseThrow(() ->new EntityNotFoundException("No se encontro cliente con id,"+id));

        //Actualizar datos
        clienteEncontrado.setNom(clienteDto.getNomb());
        clienteEncontrado.setApe(clienteDto.getApell());
        clienteEncontrado.setDir(clienteDto.getDirec());
        clienteEncontrado.setTel(clienteDto.getTele());

        Cliente clienteActualizado = clienteRepository.save(clienteEncontrado);
        return  clienteMapper.toDto(clienteActualizado);
    }

    //Eliminar datos
    @Override 
    public  ClienteDto eliminar(Long id, ClienteDto clienteDto){
        Cliente clienteEliminado = clienteRepository.findById(id)
        .orElseThrow(() ->new EntityNotFoundException("No se encontro usuario con id"+id));
         clienteRepository.delete(clienteEliminado);
        return  clienteMapper.toDto(clienteEliminado);
    }

}
