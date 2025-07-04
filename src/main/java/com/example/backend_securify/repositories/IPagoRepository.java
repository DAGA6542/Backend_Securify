package com.example.backend_securify.repositories;

import com.example.backend_securify.entities.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findPagoByMontoEquals(double precio);
}
