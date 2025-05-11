package com.example.backend_securify.repositories;

import com.example.backend_securify.dtos.ReporteUsuarioDTO;
import com.example.backend_securify.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {


    @Query("SELECT new com.example.backend_securify.dtos.ReporteUsuario(u.nombre, u.apellido, u.email, u.rol.nombre)" +
            " from Usuario u ORDER BY u.idUsuario ASC ")
    List<ReporteUsuarioDTO> listarUsuarioSeparadoPorFilas();
}
