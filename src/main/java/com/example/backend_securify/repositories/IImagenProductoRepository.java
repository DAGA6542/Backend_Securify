package com.example.backend_securify.repositories;

import com.example.backend_securify.entities.ImagenProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImagenProductoRepository extends JpaRepository<ImagenProducto, Long> {
}
