package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.ComentarioDTO;
import com.example.backend_securify.dtos.ProductoDTO;
import com.example.backend_securify.entities.Comentario;
import com.example.backend_securify.entities.Producto;
import com.example.backend_securify.interfaces.IComentarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    @Autowired
    private IComentarioService comentarioService;

    @PostMapping("/insertarcomentarios") //End Point
    public ResponseEntity<Comentario> insertarComentario(@RequestBody Comentario comentario) {
        Comentario comentarioRe = comentarioService.insertarComentario(comentario);
        return new ResponseEntity<>(comentarioRe, HttpStatus.OK);
    }

    @GetMapping("/listacomentario") //End Point
    public List<ComentarioDTO> listarComentario() {
        List<Comentario> comentarios = comentarioService.listarComentario();
        ModelMapper modelMapper = new ModelMapper();
        return comentarios.stream()
                .map(comentario -> modelMapper.map(comentario, ComentarioDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping("/actualizarcomentario/{id}")
    public void actualizarComentario(@RequestBody ComentarioDTO comentariodto) {
        ModelMapper m = new ModelMapper();
        Comentario comentario = m.map(comentariodto, Comentario.class);
        comentarioService.modificarComentario(comentario);
    }

    @DeleteMapping("/eliminarcomentario/{id}")
    public ResponseEntity<Void> eliminarComentario(@RequestParam Long comentario_id) {
        comentarioService.eliminarComentario(comentario_id);
        return ResponseEntity.noContent().build();
    }
}



