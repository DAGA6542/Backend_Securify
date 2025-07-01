package com.example.backend_securify.repositories;

import com.example.backend_securify.entities.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleOrdenRepository extends JpaRepository< DetalleOrden, Long> {
}
