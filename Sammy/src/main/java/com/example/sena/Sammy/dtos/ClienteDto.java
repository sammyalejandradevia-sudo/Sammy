package com.example.sena.Sammy.dtos;

import jakarta.persistence.Column;
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
public class ClienteDto {


    private String tipCli;
    private Integer pts;


}
