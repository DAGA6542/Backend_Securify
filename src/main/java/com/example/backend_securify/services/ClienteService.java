package com.example.backend_securify.services;
import com.example.backend_securify.dtos.ClienteDTO;
import com.example.backend_securify.entities.Cliente;
import com.example.backend_securify.interfaces.IClienteService;
import com.example.backend_securify.repositories.IClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Cliente insertar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente modificar(Cliente cliente) {
        if (clienteRepository.existsById(cliente.getCliente_id())) {
            return clienteRepository.save(cliente);
        }
        return null;
    }

    @Override
    public void eliminarPorId(Long clienteId) {
        if (clienteRepository.existsById(clienteId)) {
            clienteRepository.deleteById(clienteId);
        }

    }

    @Override
    public Cliente buscarPorId(Long clienteId) {
        return clienteRepository.findById(clienteId).orElse(null);
    }

    @Override
    public List<Cliente> listarCliente(ClienteDTO clienteDTO) {
        return List.of();
    }


    @Override
    public ClienteDTO insertarDTO(ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Cliente guardado = clienteRepository.save(cliente);
        return modelMapper.map(guardado, ClienteDTO.class);
    }

    @Override
    public void eliminarDTO(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        }


    }

    @Override
    public List<ClienteDTO> listarDTO() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }
}

