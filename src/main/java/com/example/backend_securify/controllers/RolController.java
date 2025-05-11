package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.RolDTO;
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
    public List<RolDTO> listarRol() {
        return rolService.listarRol();
    }

    @PostMapping("/guardaRol")
    public RolDTO guardarRol(@RequestBody RolDTO rol) {
        return rolService.guardarRol(rol);
    }

    @PutMapping("/actualizaRol/{idRol}")
    public ResponseEntity<RolDTO> actualizarRol(@PathVariable Long idRol, @RequestBody RolDTO rolDto) {
        RolDTO rolActualizado = rolService.ActualizarRol(idRol, rolDto);

        return ResponseEntity.ok(rolActualizado);
    }

    @DeleteMapping("/eliminarRol/{idRol}")
    public ResponseEntity<RolDTO> eliminarRol(@RequestParam Long idRol) {
        rolService.EliminarRol(idRol);
        return ResponseEntity.noContent().build();
    }
}
