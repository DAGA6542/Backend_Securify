package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.PagoDTO;
import com.example.backend_securify.dtos.ProductoDTO;
import com.example.backend_securify.interfaces.IPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {
    @Autowired
    private IPagoService pagoService;

    @GetMapping("/listapagos") //End Point
    public List<PagoDTO> listarPagos() {
        return pagoService.listarPagos();
    }

    @PostMapping("/guardapagos") //End Point
    public PagoDTO guardarPagos(@RequestBody PagoDTO pagoDto) {
        return pagoService.guardarPagos(pagoDto);
    }

    @PutMapping("/actualizarpago/{id}")
    public ResponseEntity<PagoDTO> actualizarPagos(@PathVariable Long id, @RequestBody PagoDTO pagoDto) {
        PagoDTO pagoActualizado = pagoService.actualizarPagos(id, pagoDto);
        return ResponseEntity.ok(pagoActualizado);
    }

    @DeleteMapping("/eliminarpago/{id}")
    public ResponseEntity<Void> eliminarPagos(@RequestParam Long id_pago) {
        pagoService.eliminarPagos(id_pago);
        return ResponseEntity.noContent().build();
    }
}
