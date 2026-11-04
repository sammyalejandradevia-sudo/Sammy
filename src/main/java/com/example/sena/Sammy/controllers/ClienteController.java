package com.example.sena.Sammy.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sena.Sammy.dtos.ClienteDto;
import com.example.sena.Sammy.services.ClienteServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/clientes")
@RequiredArgsConstructor 
public class ClienteController {

    private final ClienteServices clienteServices;

    //Registrar nuevo cliente
    @PostMapping 
    public ResponseEntity<ClienteDto> guardar(@Valid @RequestBody ClienteDto clienteDto){
        ClienteDto clienteguardado = clienteServices.guardar(clienteDto);

        return  ResponseEntity
            .status(HttpStatus.CREATED)
            .body(clienteguardado);
    }

    //Listar usuario
    @GetMapping
    public ResponseEntity <List<ClienteDto>>listarTodos() {
        return ResponseEntity.ok(clienteServices.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto>consultaId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteServices.buscarporId(id));
    }
    
    //Consultar por post
    @PostMapping("/buscar")
    public ResponseEntity<ClienteDto>consultaIdpost(@RequestBody ClienteDto dto) {
    ClienteDto encontrado=clienteServices.buscarporId(dto.getId());
    return ResponseEntity.ok(encontrado);
}

    //Actualizar por put
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> update(@PathVariable Long id, @RequestBody ClienteDto dto) {
    ClienteDto clienteActualizado = clienteServices.actualizar(id, dto);
    return ResponseEntity.ok(clienteActualizado);
}

    //Actualizar sin id
    @PutMapping("/actualizar")
    public ResponseEntity<ClienteDto> update( @RequestBody ClienteDto dto) {
    ClienteDto clienteActualizado = clienteServices.actualizar(dto.getId(),dto);
    return ResponseEntity.ok(clienteActualizado);
}

//Eliminar usuario
@DeleteMapping("/{id}")
public ResponseEntity<String> delete(@PathVariable Long id, @RequestBody ClienteDto dto) {
    clienteServices.eliminar(id, dto);
    return ResponseEntity.ok("cliente eliminado correctamente");
}


}
