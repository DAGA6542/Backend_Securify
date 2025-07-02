package com.example.backend_securify.controllers;


import com.example.backend_securify.dtos.CategoriaDTO;
import com.example.backend_securify.dtos.ImagenProductoDTO;
import com.example.backend_securify.entities.ImagenProducto;
import com.example.backend_securify.entities.Tienda;
import com.example.backend_securify.services.ImagenProductoService;
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
@RequestMapping("/imagenProducto")
public class ImagenProductoController {

    @Autowired
    private ImagenProductoService imagenProductoService;

    @PostMapping("/insertarimagenproducto") //End Point
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ImagenProducto> insertarImagenProducto(@RequestBody ImagenProducto imagenproducto) {
        ImagenProducto imagenproductoRe = imagenProductoService.insertarImagenProducto(imagenproducto);
        return new ResponseEntity<>(imagenproducto, HttpStatus.OK);
    }

    @GetMapping("/listaimagenproductos") //End Point
    @PreAuthorize("hasRole('ADMIN')")
    public List<ImagenProductoDTO> listarImagenProducto() {
        List<ImagenProducto> imagenproductos = imagenProductoService.listarImagenProducto();
        ModelMapper modelMapper = new ModelMapper();
        return imagenproductos.stream()
                .map(imagenproducto -> modelMapper.map(imagenproducto, ImagenProductoDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping("/actualizarimagenproducto")
    @PreAuthorize("hasRole('ADMIN')")
    public void actualizarImagenProducto(@RequestBody ImagenProductoDTO imagenproductodto) {
        ModelMapper m = new ModelMapper();
        ImagenProducto imagenproducto = m.map(imagenproductodto, ImagenProducto.class);
        imagenProductoService.modificarImagenProducto(imagenproducto);
    }


    @DeleteMapping("/eliminardetalleorden/{id}")
    public ResponseEntity<Void> eliminarImagenProducto(@RequestParam Long imagenproducto_id) {
        imagenProductoService.eliminarImagenProducto(imagenproducto_id);
        return ResponseEntity.noContent().build();
    }

    //Adap

    @PostMapping("/postimagenproducto")
    public ResponseEntity<ImagenProductoDTO> registrarImagenProducto(@RequestBody ImagenProductoDTO imagenproductodto) throws Exception {
        return ResponseEntity.ok(imagenProductoService.insertar(imagenproductodto));
    }

    @DeleteMapping("/deleteimagenproducto/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable Long id){
        imagenProductoService.eliminar(id);
    }

    @GetMapping("/listaimagenproducto/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ImagenProducto buscarPorId(@PathVariable Long id){
        return imagenProductoService.buscarImagenProductoPorId(id);
    }

}





