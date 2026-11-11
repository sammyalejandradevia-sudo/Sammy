package com.example.sena.Sammy.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@SuperBuilder 
public class TrabajadorDtoResponse extends UsuarioDto {

   
    private String cargo;
    private Double sueldo;
}
