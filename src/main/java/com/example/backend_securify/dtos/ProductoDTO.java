package com.example.backend_securify.dtos;


import com.example.backend_securify.entities.Categoria;
import com.example.backend_securify.entities.Tienda;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {

    long producto_id;
    String nombre;
    String descripcion;
    float precio;
    int stock;
    Categoria categoria_id;
    Tienda tienda_id;
}
