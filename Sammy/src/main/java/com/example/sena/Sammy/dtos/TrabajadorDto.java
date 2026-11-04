package com.example.sena.Sammy.dtos;

import com.example.sena.Sammy.models.usuarios.Usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 



public class TrabajadorDto {


    private String cargo;
    private Double Salario;


}


