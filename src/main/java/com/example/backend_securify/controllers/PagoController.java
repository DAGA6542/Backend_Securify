package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.OrdenDTO;
import com.example.backend_securify.dtos.PagoDTO;
import com.example.backend_securify.entities.Orden;
import com.example.backend_securify.entities.Pago;
import com.example.backend_securify.interfaces.IPagoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization") //para cloud
@RequestMapping("/pago")

public class PagoController {
    @Autowired
    private IPagoService pagoService;

    @PostMapping("/insertarpago") //End Point
    public ResponseEntity<Pago> insertarPago(@RequestBody Pago pago) {
        Pago pagoRe = pagoService.insertarPago(pago);
        return new ResponseEntity<>(pagoRe, HttpStatus.OK);
    }

    @GetMapping("/listapago") //End Point
    public List<PagoDTO> listarPago() {
        List<Pago> pagos = pagoService.listarPago();
        ModelMapper modelMapper = new ModelMapper();
        return pagos.stream()
                .map(pago -> modelMapper.map(pago, PagoDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping("/actualizarpago/{id}")
    public void actualizarPago(@RequestBody PagoDTO pagodto) {
        ModelMapper m = new ModelMapper();
        Pago pago = m.map(pagodto, Pago.class);
        pagoService.modificarPago(pago);
    }

    @DeleteMapping("/eliminarpago/{id}")
    public ResponseEntity<Void> eliminarPago(@RequestParam Long pago_id) {
        pagoService.eliminarPago(pago_id);
        return ResponseEntity.noContent().build();
    }
}
