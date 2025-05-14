package com.example.backend_securify.services;

import com.example.backend_securify.interfaces.IUserService;
import com.example.backend_securify.repositories.IUserRepository;
import com.example.backend_securify.security.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUserService {
    @Autowired
    private IUserRepository clienteRepository;

    @Override
    public User insertar(User user) {
        return clienteRepository.save(user);
    }

    @Override
    public User editar(User user) {
        if (clienteRepository.findById(user.getId()).isPresent()) {
            return clienteRepository.save(user);
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
    public List<User> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public User buscarPorId(long id) {
        if(clienteRepository.findById(id).isPresent()){
            return clienteRepository.findById(id).get();
        }
        return null;
    }
}
