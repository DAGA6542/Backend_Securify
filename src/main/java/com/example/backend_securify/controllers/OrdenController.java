package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.OrdenDTO;
import com.example.backend_securify.interfaces.IOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orden")
public class OrdenController {
    @Autowired
    private IOrdenService ordenService;

    @GetMapping("/listaorden") //End Point
    public List<OrdenDTO> listarOrdenes() {
        return ordenService.listarOrdenes();
    }

    @PostMapping("/guardaorden") //End Point
    public OrdenDTO guardarOrdenes(@RequestBody OrdenDTO ordenDto) {
        return ordenService.guardarOrdenes(ordenDto);
    }

    @PutMapping("/actualizarorden/{id}")
    public ResponseEntity<OrdenDTO> actualizarOrdenes(@PathVariable Long id, @RequestBody OrdenDTO ordenDto) {
        OrdenDTO ordenActualizado = ordenService.actualizarOrdenes(id, ordenDto);
        return ResponseEntity.ok(ordenActualizado);
    }

    @DeleteMapping("/eliminarorden/{id}")
    public ResponseEntity<Void> eliminarOrdenes(@RequestParam Long id_orden) {
        ordenService.eliminarOrdenes(id_orden);
        return ResponseEntity.noContent().build();
    }
}
