package com.example.sena.Sammy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sena.Sammy.models.usuarios.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
