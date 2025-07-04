package com.example.backend_securify.repositories;

import com.example.backend_securify.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE p.categoria_id.nombre = :nombreCategoria")
    List<Producto> listarProductosPorCategoria(@Param("nombreCategoria") String nombreCategoria);
    @Query("SELECT p FROM Producto p ORDER BY p.precio DESC")
    List<Producto> listarProductosPorPrecioMayorMenor();

}
