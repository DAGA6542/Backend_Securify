package com.example.backend_securify.repositories;

import com.example.backend_securify.entities.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdenRepository extends JpaRepository<Orden, Long> {
}
