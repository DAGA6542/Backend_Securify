package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.ImagenProductoDto;

import java.util.List;

public interface IImagenProductoService {

    List<ImagenProductoDto> listarImagenProducto();
    ImagenProductoDto insertProducto(ImagenProductoDto productoDTO);
    ImagenProductoDto updateProducto( Long id_Imagen, ImagenProductoDto productoDTO);
    void deleteProducto( Long id_Imagen);
}
