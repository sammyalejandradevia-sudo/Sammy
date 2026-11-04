package com.example.sena.Sammy.models.usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SuperBuilder;

@Entity 
@Table (name = "trabajadores")
@PrimaryKeyJoinColumn (name = "trabajador_id")
@Getter  @Setter
@AllArgsConstructor 
@NoArgsConstructor
@SuperBuilder 

public class Trabajador extends Usuario{
    
    private String cargo;

    private Double sueldo;

}
