package com.example.backend_securify.controllers;


import com.example.backend_securify.dtos.CategoriaDTO;
import com.example.backend_securify.interfaces.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/listacategoria") //End Point
    public List<CategoriaDTO> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @PostMapping("/guardacategoria") //End Point
    public CategoriaDTO grabarCategoria(@RequestBody CategoriaDTO categoria) {
        return categoriaService.guardarCategoria(categoria);
    }

    @PutMapping("/actualizarcategoria/{id}")
    public ResponseEntity<CategoriaDTO> actualizarCategoria( @PathVariable Long id, @RequestBody CategoriaDTO categoriaDto) {

        CategoriaDTO categoriaActualizada = categoriaService.actualizarCategoria(id, categoriaDto);
        return ResponseEntity.ok(categoriaActualizada);

    }

    @DeleteMapping("/eliminarcategoria/{id}")
    public ResponseEntity<Void> eliminarCategoria(@RequestParam Long idCategoria) {
        categoriaService.eliminarCategoria(idCategoria);
        return ResponseEntity.noContent().build();
    }
}
