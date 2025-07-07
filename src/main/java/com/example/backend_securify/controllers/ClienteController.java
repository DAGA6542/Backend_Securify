package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.ClienteDTO;
import com.example.backend_securify.entities.Cliente;
import com.example.backend_securify.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization") //para cloud
@RequestMapping("/cliente")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/insertar")
    public ResponseEntity<Cliente> insertarCliente(@RequestBody Cliente cliente) {
        Cliente clienteGuardado = clienteService.insertar(cliente);
        return new ResponseEntity<>(clienteGuardado, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarDTO();
    }



    @PutMapping("/actualizar")
    public void actualizarCliente(@RequestBody ClienteDTO clienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        clienteService.modificar(cliente);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    // Adaptación con DTO

    @PostMapping("/registrar")
    public ResponseEntity<ClienteDTO> registrarCliente(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok(clienteService.insertarDTO(clienteDTO));
    }

    @DeleteMapping("/eliminardto/{id}")
    public void eliminarDTO(@PathVariable Long id) {
        clienteService.eliminarDTO(id);
    }
}
