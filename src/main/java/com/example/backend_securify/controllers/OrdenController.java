package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.OrdenDTO;
import com.example.backend_securify.interfaces.IOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrdenController {
    @Autowired
    private IOrdenService ordenService;

    @PostMapping("/orden")
    public ResponseEntity<OrdenDTO> grabar(@RequestBody OrdenDTO ordenDto) {
        return ResponseEntity.ok(ordenService.grabarOrden(ordenDto));
    }
}
