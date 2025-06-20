package com.example.backend_securify.controllers;


import com.example.backend_securify.dtos.CategoriaDTO;
import com.example.backend_securify.entities.Categoria;
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

    //Adaptaciones

    @PutMapping("/editcategoria")
    public ResponseEntity<CategoriaDTO> editarProveedor(@RequestBody CategoriaDTO categoria){
        return ResponseEntity.ok(categoriaService.editar(categoria));
    }

    @PostMapping("/insertcategoria")
    public ResponseEntity<CategoriaDTO> registrarProveedor(@RequestBody CategoriaDTO categoria) throws Exception {

        return ResponseEntity.ok(categoriaService.insertar(categoria));
    }

    @GetMapping("/buscacategoria/{id}")
    public Categoria buscarPorId(@PathVariable Long id){
        return categoriaService.buscarPorId(id);
    }

    @DeleteMapping("/deletecat/{id}")
    public void eliminar(@PathVariable Long id){
        categoriaService.eliminar(id);
    }
}
