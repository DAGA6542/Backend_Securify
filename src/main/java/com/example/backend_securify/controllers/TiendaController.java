package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.CategoriaDTO;
import com.example.backend_securify.dtos.PagoDTO;
import com.example.backend_securify.dtos.TiendaDTO;
import com.example.backend_securify.entities.Pago;
import com.example.backend_securify.entities.Producto;
import com.example.backend_securify.entities.Tienda;
import com.example.backend_securify.interfaces.ITiendaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization") //para cloud
@RequestMapping("/tienda")
public class TiendaController {
    @Autowired
    private ITiendaService tiendaService;

    @PostMapping("/insertartienda") //End Point
    public ResponseEntity<Tienda> insertarTienda(@RequestBody Tienda tienda) {
        Tienda tiendaRe = tiendaService.insertarTienda(tienda);
        return new ResponseEntity<>(tiendaRe, HttpStatus.OK);
    }

    @GetMapping("/listatienda") //End Point
    public List<TiendaDTO> listarTienda() {
        List<Tienda> tiendas = tiendaService.listarTienda();
        ModelMapper modelMapper = new ModelMapper();
        return tiendas.stream()
                .map(tienda -> modelMapper.map(tienda, TiendaDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping("/actualizartienda")
    public void actualizarTienda(@RequestBody TiendaDTO tiendadto) {
        ModelMapper m = new ModelMapper();
        Tienda tienda = m.map(tiendadto, Tienda.class);
        tiendaService.modificarTienda(tienda);
    }

    @DeleteMapping("/eliminartienda/{id}")
    public ResponseEntity<Void> eliminarTienda(@RequestParam Long tienda_id) {
        tiendaService.eliminarTienda(tienda_id);
        return ResponseEntity.noContent().build();
    }

    //Adap

    @PostMapping("/posttienda")
    public ResponseEntity<TiendaDTO> registrarTienda(@RequestBody TiendaDTO tiendadto) throws Exception {
        return ResponseEntity.ok(tiendaService.insertar(tiendadto));
    }

    @DeleteMapping("/deletetienda/{id}")
    public void eliminar(@PathVariable Long id){
        tiendaService.eliminar(id);
    }

    @GetMapping("/listatienda/{id}")
    public Tienda buscarPorId(@PathVariable Long id){
        return tiendaService.buscarTiendaPorId(id);
    }
}
