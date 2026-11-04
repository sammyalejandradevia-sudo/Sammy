package com.example.sena.Sammy.models.usuarios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SuperBuilder;

@Entity 
@Table (name = "usuarios")
@Inheritance (strategy = InheritanceType.JOINED)//clase padre
@Getter @Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@SuperBuilder 

public class Usuario {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

   @Column (name = "nombres", nullable=false, length = 60)
    private String nom;
    @Column (name  = "apellidos", nullable=false, length = 60)
    private  String ape;
    @Column (name = "direccion",  length = 120)
    private  String dir;
    @Column (name = "telefono")
    private long tel;


}
