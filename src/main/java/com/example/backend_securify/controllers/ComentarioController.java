package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.CategoriaDTO;
import com.example.backend_securify.dtos.ComentarioDTO;
import com.example.backend_securify.dtos.ProductoDTO;
import com.example.backend_securify.entities.Categoria;
import com.example.backend_securify.entities.Comentario;
import com.example.backend_securify.entities.Producto;
import com.example.backend_securify.interfaces.IComentarioService;
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
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    private IComentarioService comentarioService;

    @PostMapping("/insertarcomentario") //End Point
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Comentario> insertarComentario(@RequestBody Comentario comentario) {
        Comentario comentarioRe = comentarioService.insertarComentario(comentario);
        return new ResponseEntity<>(comentarioRe, HttpStatus.OK);
    }

    @GetMapping("/listacomentarios") //End Point
    @PreAuthorize("hasRole('ADMIN')")
    public List<ComentarioDTO> listarComentario() {
        List<Comentario> comentarios = comentarioService.listarComentario();
        ModelMapper modelMapper = new ModelMapper();
        return comentarios.stream()
                .map(comentario -> modelMapper.map(comentario, ComentarioDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping("/actualizarcomentario")
    @PreAuthorize("hasRole('ADMIN')")
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

    //Adap

    @PostMapping("/postcomentario")
    public ResponseEntity<ComentarioDTO> registrarComentario(@RequestBody ComentarioDTO comentariodto) throws Exception {
        return ResponseEntity.ok(comentarioService.insertar(comentariodto));
    }

    @DeleteMapping("/deletecomentario/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable Long id){
        comentarioService.eliminar(id);
    }

    @GetMapping("/listacomentario/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ComentarioDTO> listaComentario(@PathVariable Long id) {
        Comentario c = comentarioService.buscarComentarioPorId(id);
        if (c == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ComentarioDTO dto = new ModelMapper().map(c, ComentarioDTO.class);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/obtenercomentariosusuario")
    public List<ComentarioDTO> obtenerComentariosPorUsuario(@RequestParam Long user_id) {
        return comentarioService.obtenerComentariosPorUsuario(user_id).stream().map(y->{
            ModelMapper m = new ModelMapper();
            m.map(y,ComentarioDTO.class);
            return m.map(y,ComentarioDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/obtenercomentarioproducto")
    public List<ComentarioDTO> obtenerComentariosPorProducto(@RequestParam Long producto_id) {
        return comentarioService.obtenerComentariosPorProducto(producto_id).stream().map(y->{
            ModelMapper m = new ModelMapper();
            m.map(y,ComentarioDTO.class);
            return m.map(y,ComentarioDTO.class);
        }).collect(Collectors.toList());
    }
}



