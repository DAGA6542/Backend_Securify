package com.example.backend_securify.controllers;


import com.example.backend_securify.dtos.ComentarioDto;
import com.example.backend_securify.interfaces.IComentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    @Autowired
    private IComentario comentarioService;

    @GetMapping("/listarcometario")
    public List<ComentarioDto> listar() {
        return comentarioService.listar();
    }


    @GetMapping("/actualizarcomentario/{id}")
    public ResponseEntity<ComentarioDto> actualizarComentario(@PathVariable Long id, @RequestBody ComentarioDto comentarioDto) {
        ComentarioDto comentarioActualizado = comentarioService.actualizarComentario(id, comentarioDto);
        return ResponseEntity.ok(comentarioActualizado);
    }


    @PostMapping("/guardarcomentario")
    public ComentarioDto guardar(@RequestBody ComentarioDto comentario) {
        return comentarioService.guardarComentario(comentario);
    }

    @DeleteMapping("/eliminarcomentario/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable Long id) {
        comentarioService.eliminarComentario(id);
        return ResponseEntity.noContent().build();
    }





}
