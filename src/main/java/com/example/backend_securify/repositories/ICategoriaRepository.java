package com.example.backend_securify.repositories;

import com.example.backend_securify.entities.Categoria;
import com.example.backend_securify.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {
}
