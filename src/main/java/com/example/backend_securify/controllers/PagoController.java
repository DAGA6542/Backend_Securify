package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.PagoDTO;
import com.example.backend_securify.interfaces.IPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class PagoController {
    @Autowired
    private IPagoService pagoService;

    @PostMapping("/pago")
    public ResponseEntity<PagoDTO> grabarPago(@RequestBody PagoDTO pagoDto) {
        return ResponseEntity.ok(pagoService.grabarPago(pagoDto));
    }

    @GetMapping("/pagoOrden")
    public ResponseEntity<List<PagoDTO>> obtenerPagoOrden(double precio) {
        return  ResponseEntity.ok(pagoService.obtenerPagoSegunMonto(precio));
    }
}
