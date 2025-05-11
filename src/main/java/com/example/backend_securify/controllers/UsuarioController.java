package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.ReporteUsuario;
import com.example.backend_securify.dtos.UsuarioDto;
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
    public List<UsuarioDto> listarUsuario() {
        return usuarioService.listarUsuarios();

    }

    @PostMapping("/guardaUsuario")
    public UsuarioDto guardarUsuario(@RequestBody UsuarioDto usuarioDto) {
        return usuarioService.guardarUsuario(usuarioDto);
    }

    @PutMapping("/actualizarUsuario/{idUsuario}")
    public ResponseEntity<UsuarioDto> actualizarUsuario(@PathVariable Long idUsuario, @RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioActualizado = usuarioService.actualizarUsuario(idUsuario, usuarioDto);
        return  ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/elimiarUsuario/{idUsuario}")
    public ResponseEntity<Void> eliminarUsuario (@PathVariable Long idUsuario) {
        usuarioService.eliminarUsuario(idUsuario);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listarReporte")
    public List<ReporteUsuario> listarReportes() {
        return usuarioService.obtenerReporteUsuarios();
    }
}
