package com.example.sena.Sammy.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sena.Sammy.dtos.UsuarioDto;
import com.example.sena.Sammy.services.UsuarioServices;

import jakarta.validation.Valid; 
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("api/usuarios") 
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServices usuarioServices;

    // Registrar nuevo usuario
    @PostMapping
    public ResponseEntity<UsuarioDto> guardar(@Valid @RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioguardado = usuarioServices.guardar(usuarioDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuarioguardado);
}

//Listar Usuario
@GetMapping
public ResponseEntity<List<UsuarioDto>> listarTodos() {
    return ResponseEntity.ok(usuarioServices.listarTodos());
}

@GetMapping("/{id}")
public ResponseEntity<UsuarioDto> consultaId(@PathVariable Long id) {
    return ResponseEntity.ok(usuarioServices.buscarporId(id));
}

//consultar por post
@PostMapping("/buscar")
public ResponseEntity<UsuarioDto>consultaIdpost(@RequestBody UsuarioDto dto) {
    UsuarioDto encontrado=usuarioServices.buscarporId(dto.getId());
    return ResponseEntity.ok(encontrado);
}

//Actualizar por put
@PutMapping("/{id}")
public ResponseEntity<UsuarioDto> update(@PathVariable Long id, @RequestBody UsuarioDto dto) {
    UsuarioDto usuarioActualizado = usuarioServices.actualizar(id, dto);
    return ResponseEntity.ok(usuarioActualizado);
}

//Actualizar sin id
@PutMapping("/actualizar")
public ResponseEntity<UsuarioDto> update( @RequestBody UsuarioDto dto) {
    UsuarioDto usuarioActualizado = usuarioServices.actualizar(dto.getId(),dto);
    return ResponseEntity.ok(usuarioActualizado);
}

//Eliminar usuario
@DeleteMapping("/{id}")
public ResponseEntity<String> delete(@PathVariable Long id, @RequestBody UsuarioDto dto) {
    usuarioServices.eliminar(id, dto);
    return ResponseEntity.ok("usuario eliminado correctamente");
}
}
