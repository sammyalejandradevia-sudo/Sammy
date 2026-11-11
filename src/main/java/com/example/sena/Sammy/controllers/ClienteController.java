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
import com.example.sena.Sammy.dtos.ClienteDtoResponse;
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
    public ResponseEntity<ClienteDtoResponse> guardar(@Valid @RequestBody ClienteDto clienteDto){
        ClienteDtoResponse clienteguardado = clienteServices.guardar(clienteDto);

        return  ResponseEntity
            .status(HttpStatus.CREATED)
            .body(clienteguardado);
    }

    //Listar usuario
    @GetMapping
    public ResponseEntity <List<ClienteDtoResponse>>listarTodos() {
        return ResponseEntity.ok(clienteServices.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDtoResponse>consultaId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteServices.buscarporId(id));
    }
    
    //Consultar por post
    @PostMapping("/buscar")
    public ResponseEntity<ClienteDtoResponse>consultaIdpost(@RequestBody ClienteDto dto) {
    ClienteDtoResponse encontrado=clienteServices.buscarporId(dto.getId());
    return ResponseEntity.ok(encontrado);
}

    //Actualizar por put
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDtoResponse> update(@PathVariable Long id, @RequestBody ClienteDto dto) {
    ClienteDtoResponse clienteActualizado = clienteServices.actualizar(id, dto);
    return ResponseEntity.ok(clienteActualizado);
}

    //Actualizar sin id
    @PutMapping("/actualizar")
    public ResponseEntity<ClienteDtoResponse> update( @RequestBody ClienteDto dto) {
    ClienteDtoResponse clienteActualizado = clienteServices.actualizar(dto.getId(),dto);
    return ResponseEntity.ok(clienteActualizado);
}

//Eliminar usuario
@DeleteMapping("/{id}")
public ResponseEntity<String> delete(@PathVariable Long id, @RequestBody ClienteDto dto) {
    clienteServices.eliminar(id, dto);
    return ResponseEntity.ok("cliente eliminado correctamente");
}


}
