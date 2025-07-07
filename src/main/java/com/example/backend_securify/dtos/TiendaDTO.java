package com.example.backend_securify.dtos;

import com.example.backend_securify.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TiendaDTO implements Serializable {
    Long tienda_id;
    String nombre;
    String descripcion;
    Cliente user_id;
}