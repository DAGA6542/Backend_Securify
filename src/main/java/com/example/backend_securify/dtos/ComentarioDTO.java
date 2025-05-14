package com.example.backend_securify.dtos;

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
    Long id_comentario;
    String contenido;
    int calificacion;
    LocalDate fecha;
    Long usuarioId;
    Long productoId;

}