package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.ProductoDTO;
import com.example.backend_securify.entities.Producto;
import com.example.backend_securify.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/listaproducto") //End Point
    public List<ProductoDTO> listarProductos() {
        return productoService.listarProductos();
    }

    @PostMapping("/guardaproducto") //End Point
    public ProductoDTO guardarProducto(@RequestBody ProductoDTO producto) {
        return productoService.guardarProducto(producto);
    }

    @PutMapping("/actualizarproducto/{id}")
    public ResponseEntity<ProductoDTO> actualizarProducto( @PathVariable Long id, @RequestBody ProductoDTO productoDto) {

        ProductoDTO productoActualizado = productoService.actualizarProducto(id, productoDto);
        return ResponseEntity.ok(productoActualizado);

    }

    @DeleteMapping("/eliminarproducto/{id}")
    public ResponseEntity<Void> eliminarProducto(@RequestParam Long idProducto) {
        productoService.eliminarProducto(idProducto);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/listarPorCategoria")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Producto>> listarProductosPorCategoria(@RequestParam("nombre") String nombreCategoria) {
        List<Producto> productos = productoService.listarProductosPorCategoria(nombreCategoria);

        return ResponseEntity.ok(productos);
    }

    @GetMapping("/listarPorPrecio")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Producto>> listarProductosPorPrecioMayorMenor() {
        List<Producto> productos = productoService.listarProductosPorPrecioMayorMenor();

        return ResponseEntity.ok(productos);
    }
}
