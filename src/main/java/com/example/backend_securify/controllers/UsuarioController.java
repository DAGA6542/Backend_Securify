package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.UserDTO;
import com.example.backend_securify.security.entities.User;
import com.example.backend_securify.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService clienteService;

    @GetMapping("/listausuarios")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDTO> listaUsers() {
        List<User> users = clienteService.listar();
        ModelMapper modelMapper = new ModelMapper();
        return users.stream()
                .map(usuario -> modelMapper.map(usuario, UserDTO.class))
                .collect(Collectors.toList());
    }

//    @PutMapping("/cliente")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<UserDTO>  editarCliente(@RequestBody UserDTO userDTO) {
//        ModelMapper modelMapper = new ModelMapper();
//        User usuario = modelMapper.map(userDTO, User.class);
//        usuario = clienteService.editar(usuario);
//        userDTO = modelMapper.map(usuario, UserDTO.class);
//        return ResponseEntity.ok(userDTO);
//    }
//    @DeleteMapping("/cliente/{id}")
//    public void eliminarCliente(@PathVariable int id) {
//        clienteService.eliminar(id);
//    }
//    @GetMapping("/cliente/{id}")
//    @PreAuthorize("hasRole('ADMIN')")

//    public ResponseEntity<UserDTO> buscaCliente(@PathVariable int id) {
//        ModelMapper modelMapper = new ModelMapper();
//        User usuario = clienteService.buscarPorId(id);
//        UserDTO userDTO = modelMapper.map(usuario, UserDTO.class);
//        return ResponseEntity.ok(userDTO);
//    }
}
