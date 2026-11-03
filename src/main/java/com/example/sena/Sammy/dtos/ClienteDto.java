package com.example.sena.Sammy.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter  
@Setter
@AllArgsConstructor 
@NoArgsConstructor 
@SuperBuilder 
public class ClienteDto  extends UsuarioDto{


    private String tipCli;
    private Integer pts;

}
