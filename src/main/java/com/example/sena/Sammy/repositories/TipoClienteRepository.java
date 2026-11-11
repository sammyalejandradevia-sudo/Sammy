package com.example.sena.Sammy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sena.Sammy.models.usuarios.TiposCliente;

public interface TipoClienteRepository extends JpaRepository <TiposCliente, Byte> {

}
