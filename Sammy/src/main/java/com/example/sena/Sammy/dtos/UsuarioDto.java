    package com.example.sena.Sammy.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter  @Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
public class UsuarioDto {

    private  Long id;

    @NotBlank (message = "el nombre es obligatorio")
    @Size (min = 2, max = 60,
        message = "el nombre debe tener entre 2 y 60 caracteres"
    )
    private String nomb;

    
    @Size (min = 3, max = 60,
        message = "el apellido debe tener entre 3 y 60 caracteres"
    )
    private String apell;


    @Size (min = 5, max = 120,
        message = "la direccion debe tener entre 5 y 120 caracteres"
    )
    private String direc;

    //comentario
    @Pattern (regexp = "^[0-9]", message = "el campo debe contener solo ")
    private Long tele;

}
