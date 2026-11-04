package com.example.sena.Sammy.models.usuarios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name = "clientes")
@PrimaryKeyJoinColumn (name = "cliente_id")
@Getter @Setter 
@AllArgsConstructor 
@NoArgsConstructor 

public class Cliente extends Usuario {

    @Column (name = "tipo_Cliente")
    private String tipoCliente;
    @Column (name = "puntos")
    private Integer puntos;

}
