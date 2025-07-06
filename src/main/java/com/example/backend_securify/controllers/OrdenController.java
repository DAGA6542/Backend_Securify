package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.CategoriaDTO;
import com.example.backend_securify.dtos.OrdenDTO;
import com.example.backend_securify.entities.Categoria;
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

    @PostMapping("/insertarorden") //End Point
    public ResponseEntity<Orden> insertarOrden(@RequestBody Orden orden) {
        Orden ordenRe = ordenService.insertarOrden(orden);
        return new ResponseEntity<>(ordenRe, HttpStatus.OK);
    }

    @GetMapping("/listaordenes") //End Point
    public List<OrdenDTO> listarOrden() {
        List<Orden> ordenes = ordenService.listarOrden();
        ModelMapper modelMapper = new ModelMapper();
        return ordenes.stream()
                .map(orden -> modelMapper.map(orden, OrdenDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping("/actualizarorden")
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

    //Adap

    @PostMapping("/postorden")
    public ResponseEntity<OrdenDTO> registrarOrden(@RequestBody OrdenDTO ordendto) throws Exception {
        return ResponseEntity.ok(ordenService.insertar(ordendto));
    }

    @DeleteMapping("/deleteorden/{id}")
    public void eliminar(@PathVariable Long id){
        ordenService.eliminar(id);
    }

    @GetMapping("/listaorden/{id}")
    public ResponseEntity<OrdenDTO> buscarOrden(@PathVariable Long id) {
        Orden c = ordenService.buscarOrdenPorId(id);
        if (c == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        OrdenDTO dto = new ModelMapper().map(c, OrdenDTO.class);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
