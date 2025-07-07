package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.ProductoDTO;
import com.example.backend_securify.entities.Producto;
import com.example.backend_securify.interfaces.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization") //para cloud
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @PostMapping("/insertarproducto") //End Point
    @PreAuthorize("hasRole('ADMIN')")
        public ResponseEntity<Producto> insertarProducto(@RequestBody Producto producto) {
        Producto productoRe = productoService.insertarProducto(producto);
        return new ResponseEntity<>(productoRe, HttpStatus.OK);
    }

    @GetMapping("/listaproducto") //End Point
    @PreAuthorize("hasRole('ADMIN')")
    public List<ProductoDTO> listarProductos() {
        List<Producto> productos = productoService.listarProductos();
        ModelMapper modelMapper = new ModelMapper();
        return productos.stream()
                .map(producto -> modelMapper.map(producto, ProductoDTO.class))
                .collect(Collectors.toList());
    }


    @PutMapping("/actualizarproducto")
    @PreAuthorize("hasRole('ADMIN')")
    public void actualizarProducto(@RequestBody ProductoDTO productodto) {
        ModelMapper m = new ModelMapper();
        Producto producto = m.map(productodto, Producto.class);
        productoService.modificarProducto(producto);
    }

    @DeleteMapping("/eliminarproducto/{id}")
    public ResponseEntity<Void> eliminarProducto(@RequestParam Long producto_id) {
        productoService.eliminarProducto(producto_id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/listarPorCategoria")

    public ResponseEntity<List<Producto>> listarProductosPorCategoria(@RequestParam("nombre") String nombreCategoria) {
        List<Producto> productos = productoService.listarProductosPorCategoria(nombreCategoria);

        return ResponseEntity.ok(productos);
    }

    @GetMapping("/listarPorPrecio")

    public ResponseEntity<List<Producto>> listarProductosPorPrecioMayorMenor() {
        List<Producto> productos = productoService.listarProductosPorPrecioMayorMenor();

        return ResponseEntity.ok(productos);
    }

    //Adap

    @PostMapping("/postproducto")
    public ResponseEntity<ProductoDTO> registrarProducto(@RequestBody ProductoDTO productodto) throws Exception {
        return ResponseEntity.ok(productoService.insertar(productodto));
    }

    @DeleteMapping("/deleteproducto/{id}")
    public void eliminar(@PathVariable Long id){
        productoService.eliminar(id);
    }

    @GetMapping("/listaproducto/{id}")
    public Producto buscarPorId(@PathVariable Long id){
        return productoService.buscarProductoPorId(id);
    }
}
