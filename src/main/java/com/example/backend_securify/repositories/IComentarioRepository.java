package com.example.backend_securify.repositories;

import com.example.backend_securify.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.function.LongFunction;

public interface IComentarioRepository extends JpaRepository<Comentario, Long> {
    //Buscar todos los comentarios por usuario
    @Query (" select c from Comentario c where c.user_id.id = :user_id")
    List<Comentario> obtenerComentariosPorUsuario(@Param("user_id") Long user_id);
    //Buscar todos los comentarios por producto
    @Query (" select c from Comentario c where c.producto_id.producto_id = :producto_id")
    List<Comentario> obtenerComentariosPorProducto(@Param("producto_id") Long producto_id);
}
