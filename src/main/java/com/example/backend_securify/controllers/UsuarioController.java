package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.ReporteUsuarioDTO;
import com.example.backend_securify.dtos.UsuarioDTO;
import com.example.backend_securify.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/listaUsuario")
    public List<UsuarioDTO> listarUsuario() {
        return usuarioService.listarUsuarios();

    }

    @PostMapping("/guardaUsuario")
    public UsuarioDTO guardarUsuario(@RequestBody UsuarioDTO usuarioDto) {
        return usuarioService.guardarUsuario(usuarioDto);
    }

    @PutMapping("/actualizarUsuario/{idUsuario}")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@PathVariable Long idUsuario, @RequestBody UsuarioDTO usuarioDto) {
        UsuarioDTO usuarioActualizado = usuarioService.actualizarUsuario(idUsuario, usuarioDto);
        return  ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/elimiarUsuario/{idUsuario}")
    public ResponseEntity<Void> eliminarUsuario (@PathVariable Long idUsuario) {
        usuarioService.eliminarUsuario(idUsuario);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listarReporte")
    public List<ReporteUsuarioDTO> listarReportes() {
        return usuarioService.obtenerReporteUsuarios();
    }
}
