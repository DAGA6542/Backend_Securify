package com.example.backend_securify.services;

import com.example.backend_securify.dtos.CategoriaDTO;
import com.example.backend_securify.dtos.ProductoDTO;
import com.example.backend_securify.entities.Categoria;
import com.example.backend_securify.entities.Producto;
import com.example.backend_securify.interfaces.IProductoService;
import com.example.backend_securify.repositories.IProductoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired //inyecta
    private IProductoRepository productoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Producto insertarProducto(Producto producto) { return productoRepository.save(producto); }

    @Transactional
    @Override
    public void eliminarProducto (Long idProducto) {
        if (productoRepository.existsById(idProducto)) {
            productoRepository.deleteById(idProducto);
        }
    }

    @Transactional
    @Override
    public Producto modificarProducto(Producto producto) {
        if(productoRepository.findById(producto.getProducto_id()).isPresent()){
            return productoRepository.save(producto);
        }
        return null;
    }

    @Override
    public List<Producto> listarProductos() { return productoRepository.findAll(); }

    @Override
    public Producto buscarProductoPorId(long id) {
        if(productoRepository.findById(id).isPresent()){
            return productoRepository.findById(id).get();
        }
        return null;
    }


    @Override
    public List<Producto> listarProductosPorCategoria(String nombreCategoria) {
        return productoRepository.listarProductosPorCategoria(nombreCategoria);
    }

    @Override
    public List<Producto> listarProductosPorPrecioMayorMenor() {
        return productoRepository.listarProductosPorPrecioMayorMenor();
    }

    @Override
    public ProductoDTO insertar(ProductoDTO producto) {
        //Convertir el DTO en Entidad
        Producto proveedorEntidad = modelMapper.map(producto, Producto.class);
        Producto guardado = productoRepository.save(proveedorEntidad);
        return modelMapper.map(guardado, ProductoDTO.class);
    }

    @Override
    public void eliminar(Long id) {
        if(productoRepository.existsById(id)){
            productoRepository.deleteById(id);
        }
    }
}
