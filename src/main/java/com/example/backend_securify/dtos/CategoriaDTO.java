package com.example.backend_securify.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {

    long categoria_id;
    String nombre;
    String descripcion;
}
