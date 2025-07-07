package com.example.backend_securify.dtos;

import com.example.backend_securify.entities.Producto;
import com.example.backend_securify.security.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ComentarioDTO implements Serializable {
    Long comentario_id;
    String contenido;
    int calificacion;
    LocalDate fecha;
    User user_id;
    Producto producto_id;
}