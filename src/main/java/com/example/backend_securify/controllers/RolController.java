package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.RolDto;
import com.example.backend_securify.interfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private IRolService rolService;

    @GetMapping("/listaRol")
    public List<RolDto> listarRol() {
        return rolService.listarRol();
    }

    @PostMapping("/guardaRol")
    public RolDto guardarRol(@RequestBody RolDto rol) {
        return rolService.guardarRol(rol);
    }

    @PutMapping("/actualizaRol/{idRol}")
    public ResponseEntity<RolDto> actualizarRol(@PathVariable Long idRol, @RequestBody RolDto rolDto) {
        RolDto rolActualizado = rolService.ActualizarRol(idRol, rolDto);

        return ResponseEntity.ok(rolActualizado);
    }

    @DeleteMapping("/eliminarRol/{idRol}")
    public ResponseEntity<RolDto> eliminarRol(@RequestParam Long idRol) {
        rolService.EliminarRol(idRol);
        return ResponseEntity.noContent().build();
    }
}
