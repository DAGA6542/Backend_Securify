package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.ProductoDTO;

import java.util.List;

public interface IProductoService {

    List<ProductoDTO> listarProductos();
    ProductoDTO guardarProducto(ProductoDTO producto);
    ProductoDTO actualizarProducto(Long idProducto, ProductoDTO productoDto);
    void eliminarProducto(Long idProducto);
}
