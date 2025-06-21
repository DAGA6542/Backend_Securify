package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.ComentarioDTO;
import com.example.backend_securify.dtos.DetalleOrdenDTO;
import com.example.backend_securify.entities.Comentario;
import com.example.backend_securify.entities.DetalleOrden;
import com.example.backend_securify.interfaces.IDetalleOrdenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization") //para cloud
@RequestMapping("/detalleorden")
public class DetalleOrdenController {

    @Autowired
    private IDetalleOrdenService detalleOrdenService;

    @PostMapping("/insertardetalleorden") //End Point
    public ResponseEntity<DetalleOrden> insertarDetalleOrden(@RequestBody DetalleOrden detalleorden) {
        DetalleOrden detalleordenRe = detalleOrdenService.insertarDetalleOrden(detalleorden);
        return new ResponseEntity<>(detalleordenRe, HttpStatus.OK);
    }

    @GetMapping("/listadetalleorden") //End Point
    public List<DetalleOrdenDTO> listarDetalleOrden() {
        List<DetalleOrden> detalleordenes = detalleOrdenService.listarDetalleOrden();
        ModelMapper modelMapper = new ModelMapper();
        return detalleordenes.stream()
                .map(detalleorden -> modelMapper.map(detalleorden, DetalleOrdenDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping("/actualizardetalleorden/{id}")
    public void actualizarDetalleOrden(@RequestBody DetalleOrdenDTO detalleordendto) {
        ModelMapper m = new ModelMapper();
        DetalleOrden detalleorden = m.map(detalleordendto, DetalleOrden.class);
        detalleOrdenService.modificarDetalleOrden(detalleorden);
    }

    @DeleteMapping("/eliminardetalleorden/{id}")
    public ResponseEntity<Void> eliminarDetalleOrden(@RequestParam Long detalleorden_id) {
        detalleOrdenService.eliminarDetalleOrden(detalleorden_id);
        return ResponseEntity.noContent().build();
    }
}

