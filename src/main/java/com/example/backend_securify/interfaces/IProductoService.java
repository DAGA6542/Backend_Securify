package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.ProductoDTO;
import com.example.backend_securify.entities.Producto;

import java.util.List;

public interface IProductoService {
    public Producto insertarProducto(Producto producto);
    public void eliminarProducto(Long idProducto);
    public Producto modificarProducto(Producto producto);
    public List<Producto> listarProductos();
    public Producto buscarProductoPorId(long idProducto);

    public List<Producto> listarProductosPorCategoria(String nombreCategoria);
    public List<Producto> listarProductosPorPrecioMayorMenor();
}
