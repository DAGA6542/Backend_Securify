package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.ClienteDTO;
import com.example.backend_securify.entities.Cliente;
import com.example.backend_securify.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ClienteDTO> listaClientes() {
        List<Cliente> clientes = clienteService.listar();
        ModelMapper modelMapper = new ModelMapper();
        return clientes.stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }
    @PostMapping("/cliente")
    public ResponseEntity<ClienteDTO> adicionaCliente(@RequestBody ClienteDTO clienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        cliente = clienteService.insertar(cliente);
        clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
        return ResponseEntity.ok(clienteDTO);
    }
    @PutMapping("/cliente")
    public ResponseEntity<ClienteDTO>  editarCliente(@RequestBody ClienteDTO clienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        cliente = clienteService.editar(cliente);
        clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
        return ResponseEntity.ok(clienteDTO);
    }
    @DeleteMapping("/cliente/{id}")
    public void eliminarCliente(@PathVariable int id) {
        clienteService.eliminar(id);
    }
    @GetMapping("/cliente/{id}")
    public ResponseEntity<ClienteDTO> buscaCliente(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = clienteService.buscarPorId(id);
        ClienteDTO clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
        return ResponseEntity.ok(clienteDTO);
    }
}
