package com.example.sena.Sammy.servicesImplement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sena.Sammy.dtos.ClienteDto;
import com.example.sena.Sammy.dtos.ClienteDtoResponse;
import com.example.sena.Sammy.mappers.ClienteMapper;
import com.example.sena.Sammy.models.usuarios.Cliente;
import com.example.sena.Sammy.models.usuarios.TiposCliente;
import com.example.sena.Sammy.repositories.ClienteRepository;
import com.example.sena.Sammy.repositories.TipoClienteRepository;
import com.example.sena.Sammy.services.ClienteServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class ClienteServicesImpl implements ClienteServices{
    
    private final ClienteRepository clienteRepository;
    private  final ClienteMapper clienteMapper;
    private  final TipoClienteRepository tiCliRepo;

    @Override 
    public ClienteDtoResponse guardar(ClienteDto clienteDto){

        //1.buscar id de tipocliente a base de datos
        TiposCliente tipo= tiCliRepo.findById(clienteDto.getTipCli())
        .orElseThrow(()->new EntityNotFoundException("tipo cliente no encontrado"));

        //2.Convierte Dto a Entidad
        Cliente cliente = clienteMapper.toEntidad(clienteDto);

        //3.El Id del cliente debe ser null por que es autoincrementable
        cliente.setId(null);

        //4.Asigna tipocliente "id"
        cliente.setTipoCliente(tipo);

        //5.guarda cliente en base de datos
        Cliente clienteguardado = clienteRepository.save(cliente);

        return  clienteMapper.toDto(clienteguardado);
    }



    //Listar todos
    @Override 
    public List<ClienteDtoResponse>listarTodos(){
        return  clienteRepository.findAll()
        .stream()
        .map(clienteMapper::toDto)
        .toList();
    }

    //Consultar usuario por Id
    @Override 
    public ClienteDtoResponse buscarporId(Long id){
        Cliente cliente=clienteRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("cliente no encontrado"+id));
        return  clienteMapper.toDto(cliente);
    }

    //Actualizar usuario
      @Override 
    public ClienteDtoResponse actualizar(Long id, ClienteDto clienteDto){
        Cliente clienteEncontrado = clienteRepository.findById(id)
        .orElseThrow(() ->new EntityNotFoundException("No se encontro cliente con id,"+id));

        //Actualizar datos
        clienteEncontrado.setNom(clienteDto.getNomb());
        clienteEncontrado.setApe(clienteDto.getApell());
        clienteEncontrado.setDir(clienteDto.getDirec());
        clienteEncontrado.setTel(clienteDto.getTele());

        //Atributos propios del cliente
        clienteEncontrado.setPuntos(clienteDto.getPts());
        clienteEncontrado.setTipoCliente(tiCliRepo.findById(clienteDto.getTipCli())
        .orElseThrow(() -> new EntityNotFoundException("No se encontro tipo de cliente " + clienteDto.getTipCli())));

        Cliente clienteActualizado = clienteRepository.save(clienteEncontrado);
        return  clienteMapper.toDto(clienteActualizado);
    }

    //Eliminar datos
    @Override 
    public  ClienteDtoResponse eliminar(Long id, ClienteDto clienteDto){
        Cliente clienteEliminado = clienteRepository.findById(id)
        .orElseThrow(() ->new EntityNotFoundException("No se encontro usuario con id"+id));
         clienteRepository.delete(clienteEliminado);
        return  clienteMapper.toDto(clienteEliminado);
    }

}
