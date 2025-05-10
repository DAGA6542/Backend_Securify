package com.example.backend_securify.dtos;


import com.example.backend_securify.entities.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {

    long idProducto;
    String nombre;
    String descripcion;
    float precio;
    int stock;
    Categoria id_categoria;
}
