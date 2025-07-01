package com.example.backend_securify.controllers;


import com.example.backend_securify.dtos.CategoriaDTO;
import com.example.backend_securify.entities.Categoria;
import com.example.backend_securify.interfaces.ICategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization") //para cloud
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @PostMapping("/insertarcategoria") //End Point
    public ResponseEntity<Categoria> insertarCategoria(@RequestBody Categoria categoria) {
        Categoria categoriaRe = categoriaService.insertarCategoria(categoria);
        return new ResponseEntity<>(categoriaRe, HttpStatus.OK);
    }

    @GetMapping("/listacategoria") //End Point
    public List<CategoriaDTO> listarCategoria() {
        List<Categoria> categorias = categoriaService.listarCategorias();
        ModelMapper modelMapper = new ModelMapper();
        return categorias.stream()
                .map(categoria -> modelMapper.map(categoria, CategoriaDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping("/actualizarcategoria/{id}")
    public void actualizarCategoria(@RequestBody CategoriaDTO categoriadto) {
        ModelMapper m = new ModelMapper();
        Categoria categoria = m.map(categoriadto, Categoria.class);
        categoriaService.modificarCategoria(categoria);
    }

    @DeleteMapping("/eliminarcategoria/{id}")
    public ResponseEntity<Void> eliminarCategoria(@RequestParam Long categoria_id) {
        categoriaService.eliminarCategoria(categoria_id);
        return ResponseEntity.noContent().build();
    }

}
