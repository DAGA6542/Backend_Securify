package com.example.backend_securify.repositories;

import com.example.backend_securify.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComentarioRepository extends JpaRepository<Comentario, Long> {
}
