package com.example.backend_securify.interfaces;

import com.example.backend_securify.dtos.ClienteDTO;
import com.example.backend_securify.entities.Cliente;

import java.util.List;

public interface IClienteService {
    // Métodos con entidad Cliente
    Cliente insertar(Cliente cliente);
    Cliente modificar(Cliente cliente);
    void eliminarPorId(Long clienteId);
    Cliente buscarPorId(Long clienteId);
    List<Cliente> listarCliente(ClienteDTO clienteDTO);

    // Métodos con DTO
    ClienteDTO insertarDTO(ClienteDTO clienteDTO);
    void eliminarDTO(Long id);
    List<ClienteDTO> listarDTO();
}
