package com.example.backend_securify.services;

import com.example.backend_securify.entities.Cliente;
import com.example.backend_securify.interfaces.IClienteService;
import com.example.backend_securify.repositories.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public Cliente insertar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente editar(Cliente cliente) {
        if (clienteRepository.findById(cliente.getClienteId()).isPresent()) {
            return clienteRepository.save(cliente);
        }
        return null;
    }

    @Override
    public void eliminar(long id) {
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        }
    }

    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(long id) {
        if(clienteRepository.findById(id).isPresent()){
            return clienteRepository.findById(id).get();
        }
        return null;
    }
}
