package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.TiendaDto;
import com.example.backend_securify.interfaces.ITienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiendas")
public class TiendaController {
    @Autowired
    private ITienda tiendaService;

    @GetMapping("/listartienda")
    public List<TiendaDto> listar() {
        return tiendaService.listar();
    }
    @PutMapping("/actualizartienda/{id}")
    public ResponseEntity<TiendaDto> actualizarTienda(@PathVariable Long id, @RequestBody TiendaDto tiendaDto) {
        TiendaDto tiendaActualizada = tiendaService.actualizarTienda(id, tiendaDto);
        return ResponseEntity.ok(tiendaActualizada);
    }



    @PostMapping("/guardartienda")
    public TiendaDto guardarTienda(@RequestBody TiendaDto tienda) {

        return tiendaService.guardarTienda(tienda);
    }


    @DeleteMapping("/eliminartienda/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tiendaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }


}
