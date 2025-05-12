package com.example.backend_securify.repositories;

import com.example.backend_securify.entities.Cliente;
import com.example.backend_securify.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
