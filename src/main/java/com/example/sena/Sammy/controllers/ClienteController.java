package com.example.sena.Sammy.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sena.Sammy.dtos.ClienteDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

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

}
