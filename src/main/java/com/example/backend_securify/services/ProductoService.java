package com.example.backend_securify.services;

import com.example.backend_securify.dtos.ProductoDTO;
import com.example.backend_securify.entities.Producto;
import com.example.backend_securify.interfaces.IProductoService;
import com.example.backend_securify.repositories.IProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService {

    @Autowired //inyecta
    private IProductoRepository productoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductoDTO> listarProductos() {
        return productoRepository.findAll()
                .stream()
                .map(producto -> modelMapper.map(producto, ProductoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO guardarProducto(ProductoDTO producto) {
        Producto p = modelMapper.map(producto, Producto.class);
        Producto save = productoRepository.save(p);
        return modelMapper.map(save, ProductoDTO.class);
    }

    @Override
    public ProductoDTO actualizarProducto(Long idProducto, ProductoDTO productoDTO) {

        Producto p = productoRepository.findById(idProducto).get();
        modelMapper.map(productoDTO, p);

        Producto productoActualizado = productoRepository.save(p);

        return modelMapper.map(productoActualizado, ProductoDTO.class);
    }

    @Override
    public void eliminarProducto (Long idProducto) {
        if (productoRepository.existsById(idProducto)) {
            productoRepository.deleteById(idProducto);
        }
    }

    @Override
    public List<Producto> listarProductosPorCategoria(String nombreCategoria) {
        return productoRepository.listarProductosPorCategoria(nombreCategoria);
    }

    @Override
    public List<Producto> listarProductosPorPrecioMayorMenor() {
        return productoRepository.listarProductosPorPrecioMayorMenor();
    }

}
