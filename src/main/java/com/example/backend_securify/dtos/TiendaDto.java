package com.example.backend_securify.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TiendaDto implements Serializable {
    Long id_tienda;
    String nombre;
    String descripcion;
    Long usuarioId;
}