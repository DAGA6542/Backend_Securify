package com.example.backend_securify.interfaces;

import com.example.backend_securify.entities.Producto;

import java.util.List;

public interface IProductoService {
    public Producto insertarProducto(Producto producto);
    public void eliminarProducto(Long producto_id);
    public Producto modificarProducto(Producto producto);
    public List<Producto> listarProductos();
    public Producto buscarProductoPorId(long producto_id);

    public List<Producto> listarProductosPorCategoria(String nombreCategoria);
    public List<Producto> listarProductosPorPrecioMayorMenor();
}
