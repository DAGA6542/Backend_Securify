package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.OrdenDTO;
import com.example.backend_securify.entities.Orden;
import com.example.backend_securify.interfaces.IOrdenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization") //para cloud
@RequestMapping("/orden")
public class OrdenController {

    @Autowired
    private IOrdenService ordenService;

    @PostMapping("/insertaorden") //End Point
    public ResponseEntity<Orden> insertarOrden(@RequestBody Orden orden) {
        Orden ordenRe = ordenService.insertarOrden(orden);
        return new ResponseEntity<>(ordenRe, HttpStatus.OK);
    }

    @GetMapping("/listaorden") //End Point
    public List<OrdenDTO> listarOrden() {
        List<Orden> ordenes = ordenService.listarOrden();
        ModelMapper modelMapper = new ModelMapper();
        return ordenes.stream()
                .map(orden -> modelMapper.map(orden, OrdenDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping("/actualizarorden/{id}")
    public void actualizarOrden(@RequestBody OrdenDTO ordendto) {
        ModelMapper m = new ModelMapper();
        Orden orden = m.map(ordendto, Orden.class);
        ordenService.modificarOrden(orden);
    }

    @DeleteMapping("/eliminarorden/{id}")
    public ResponseEntity<Void> eliminarOrden(@RequestParam Long orden_id) {
        ordenService.eliminarOrden(orden_id);
        return ResponseEntity.noContent().build();
    }

}
