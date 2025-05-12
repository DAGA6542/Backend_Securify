package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.ProductoDTO;
import com.example.backend_securify.entities.Producto;

import java.util.List;

public interface IProductoService {

    List<ProductoDTO> listarProductos();
    ProductoDTO guardarProducto(ProductoDTO producto);
    ProductoDTO actualizarProducto(Long idProducto, ProductoDTO productoDto);
    void eliminarProducto(Long idProducto);
    List<Producto> listarProductosPorCategoria(String nombreCategoria);
    List<Producto> listarProductosPorPrecioMayorMenor();
}
