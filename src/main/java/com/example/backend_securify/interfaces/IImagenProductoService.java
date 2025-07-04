package com.example.backend_securify.interfaces;

import com.example.backend_securify.entities.ImagenProducto;

import java.util.List;

public interface IImagenProductoService {

    public ImagenProducto insertarImagenProducto(ImagenProducto imagenProducto);
    public void eliminarImagenProducto(Long detalleorden_id);
    public ImagenProducto modificarImagenProducto(ImagenProducto imagenProducto);
    public List<ImagenProducto> listarImagenProducto();
    public ImagenProducto buscarImagenProductoPorId(long imagenproducto_id);
}
