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
import com.example.sena.Sammy.dtos.TrabajadorDto;
import com.example.sena.Sammy.dtos.TrabajadorDtoResponse;

import com.example.sena.Sammy.services.TrabajadorServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/trabajador")
@RequiredArgsConstructor 
public class TrabajadorController {


    private final TrabajadorServices trabajadorServices;

    
    //Registrar nuevo cliente
    @PostMapping 
    public ResponseEntity<TrabajadorDtoResponse> guardar(@Valid @RequestBody TrabajadorDto trabajadorDto){
        TrabajadorDtoResponse trabajadorguardado = trabajadorServices.guardar(trabajadorDto);

        return  ResponseEntity
            .status(HttpStatus.CREATED)
            .body(trabajadorguardado);
    }
// Buscar Usuario
    @GetMapping("/{id}")
    public ResponseEntity<TrabajadorDtoResponse> buscarporId(@PathVariable Long id) {
    return ResponseEntity.ok(trabajadorServices.buscarporId(id));
    }  

//Consultar por post
    @PostMapping("/buscar")
    public ResponseEntity<TrabajadorDtoResponse>consultaIdpost(@RequestBody TrabajadorDto dto) {
    TrabajadorDtoResponse encontrado=trabajadorServices.buscarporId(dto.getId());
    return ResponseEntity.ok(encontrado);
}

    //Actualizar por put
    @PutMapping("/{id}")
    public ResponseEntity<TrabajadorDtoResponse> update(@PathVariable Long id, @RequestBody TrabajadorDto dto) {
    TrabajadorDtoResponse trabajadorActualizado = trabajadorServices.actualizar(id, dto);
    return ResponseEntity.ok(trabajadorActualizado);
}

    //Eliminar usuario
@DeleteMapping("/{id}")
public ResponseEntity<String> delete(@PathVariable Long id, @RequestBody TrabajadorDto dto) {
    trabajadorServices.eliminar(id, dto);
    return ResponseEntity.ok("trabajador eliminado correctamente");
}


    

    
}
