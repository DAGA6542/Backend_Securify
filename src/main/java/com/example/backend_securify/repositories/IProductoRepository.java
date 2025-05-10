package com.example.backend_securify.repositories;

import com.example.backend_securify.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {

}
