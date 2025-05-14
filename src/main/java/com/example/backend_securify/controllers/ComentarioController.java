package com.example.backend_securify.controllers;


import com.example.backend_securify.dtos.ComentarioDTO;
import com.example.backend_securify.interfaces.IComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    @Autowired
    private IComentarioService comentarioService;

    @GetMapping("/listarcometario")
    public List<ComentarioDTO> listar() {
        return comentarioService.listar();
    }


    @GetMapping("/actualizarcomentario/{id}")
    public ResponseEntity<ComentarioDTO> actualizarComentario(@PathVariable Long id, @RequestBody ComentarioDTO comentarioDto) {
        ComentarioDTO comentarioActualizado = comentarioService.actualizarComentario(id, comentarioDto);
        return ResponseEntity.ok(comentarioActualizado);
    }


    @PostMapping("/guardarcomentario")
    public ComentarioDTO guardar(@RequestBody ComentarioDTO comentario) {
        return comentarioService.guardarComentario(comentario);
    }

    @DeleteMapping("/eliminarcomentario/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable Long id) {
        comentarioService.eliminarComentario(id);
        return ResponseEntity.noContent().build();
    }

}
