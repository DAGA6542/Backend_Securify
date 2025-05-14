package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.ImagenProductoDto;
import com.example.backend_securify.services.ImagenProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagenproducto")
public class ImagenProductoController {
    @Autowired
    private ImagenProductoService imagenProductoService;

    @GetMapping("/listarimagenes")
    public List<ImagenProductoDto> listarImagenes(){return imagenProductoService.listarImagenProducto();}

    @GetMapping("/actualizaimagenes")
    public ResponseEntity<ImagenProductoDto> actualizarImagenes(@PathVariable Long id, @RequestBody ImagenProductoDto imagenProductoDto){
        ImagenProductoDto imagenProductoDtoACTUALIZAR = imagenProductoService.updateProducto(id, imagenProductoDto);
        return ResponseEntity.ok(imagenProductoDtoACTUALIZAR);
    }

    @PostMapping("/insertarimagen")
    public ImagenProductoDto insertarImagen(@RequestBody ImagenProductoDto imagenProductoDto){
        return imagenProductoService.insertProducto(imagenProductoDto);
    }

    @DeleteMapping("/eliminarimagen/{id}")
    public ResponseEntity<Void> eliminarImagen(@PathVariable Long id){
        imagenProductoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }
}
