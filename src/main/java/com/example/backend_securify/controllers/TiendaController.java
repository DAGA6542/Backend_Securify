package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.TiendaDTO;
import com.example.backend_securify.interfaces.ITiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiendas")
public class TiendaController {
    @Autowired
    private ITiendaService tiendaService;

    @GetMapping("/listartienda")
    public List<TiendaDTO> listar() {
        return tiendaService.listar();
    }
    @PutMapping("/actualizartienda/{id}")
    public ResponseEntity<TiendaDTO> actualizarTienda(@PathVariable Long id, @RequestBody TiendaDTO tiendaDto) {
        TiendaDTO tiendaActualizada = tiendaService.actualizarTienda(id, tiendaDto);
        return ResponseEntity.ok(tiendaActualizada);
    }



    @PostMapping("/guardartienda")
    public TiendaDTO guardarTienda(@RequestBody TiendaDTO tienda) {

        return tiendaService.guardarTienda(tienda);
    }


    @DeleteMapping("/eliminartienda/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tiendaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }


}
