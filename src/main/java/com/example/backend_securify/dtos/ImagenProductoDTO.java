package com.example.backend_securify.dtos;

import com.example.backend_securify.entities.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImagenProductoDTO implements Serializable {
    Long imagenproducto_id;
    String urlImagen;
    Producto producto_id;
}