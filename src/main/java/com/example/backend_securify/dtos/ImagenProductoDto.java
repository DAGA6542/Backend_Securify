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
public class ImagenProductoDto implements Serializable {
    Long id_Imagen;
    String urlImagen;
    Producto producto;
}