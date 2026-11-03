    package com.example.sena.Sammy.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter  @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UsuarioDto {

    private  Long id;

    @NotBlank (message = "el nombre es obligatorio")
    @Size (min = 2, max = 60,
        message = "el nombre debe tener entre 2 y 60 caracteres")
    private String nomb;


    @Size (min = 2, max = 60,
        message = "el apellido debe tener entre 2 y 60 caracteres" )
    private String apell;


    @Size ( max = 120,
        message = "la direccion no puede superar los 120 caracteres")
    private String direc;

    //comentario
    @Pattern (regexp = "^[0-9+//-]+$", message = "el telefono contiene caracteres no permitidos ")
    private String tele;

}
