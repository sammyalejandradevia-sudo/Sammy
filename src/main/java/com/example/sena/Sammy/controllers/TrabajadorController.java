package com.example.sena.Sammy.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.sena.Sammy.dtos.TrabajadorDto;
import java.util.List;
import com.example.sena.Sammy.services.TrabajadorServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/trabajadores")
@RequiredArgsConstructor 
public class TrabajadorController {


    private final TrabajadorServices trabajadorServices;

    
    //Registrar nuevo cliente
    @PostMapping 
    public ResponseEntity<TrabajadorDto> guardar(@Valid @RequestBody TrabajadorDto trabajadorDto){
        TrabajadorDto trabajadorguardado = trabajadorServices.guardar(trabajadorDto);

        return  ResponseEntity
            .status(HttpStatus.CREATED)
            .body(trabajadorguardado);
    }

    //Listar usuario
    @GetMapping
    public ResponseEntity <List<TrabajadorDto>>listarTodos() {
        return ResponseEntity.ok(trabajadorServices.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabajadorDto>consultaId(@PathVariable Long id) {
        return ResponseEntity.ok(trabajadorServices.buscarporId(id));
    }
    
    //Consultar por post
    @PostMapping("/buscar")
    public ResponseEntity<TrabajadorDto>consultaIdpost(@RequestBody TrabajadorDto dto) {
    TrabajadorDto encontrado=trabajadorServices.buscarporId(dto.getId());
    return ResponseEntity.ok(encontrado);
}

    //Actualizar por put
    @PutMapping("/{id}")
    public ResponseEntity<TrabajadorDto> update(@PathVariable Long id, @RequestBody TrabajadorDto dto) {
    TrabajadorDto trabajadorActualizado = trabajadorServices.actualizar(id, dto);
    return ResponseEntity.ok(trabajadorActualizado);
}

    //Actualizar sin id
    @PutMapping("/actualizar")
    public ResponseEntity<TrabajadorDto> update( @RequestBody TrabajadorDto dto) {
    TrabajadorDto trabajadorActualizado = trabajadorServices.actualizar(dto.getId(),dto);
    return ResponseEntity.ok(trabajadorActualizado);
}

//Eliminar usuario
@DeleteMapping("/{id}")
public ResponseEntity<String> delete(@PathVariable Long id, @RequestBody TrabajadorDto dto) {
   trabajadorServices.eliminar(id, dto);
    return ResponseEntity.ok("trabajador eliminado correctamente");
}


}
