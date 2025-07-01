package com.example.backend_securify.services;

import com.example.backend_securify.interfaces.IUserService;
import com.example.backend_securify.repositories.IUserRepository;
import com.example.backend_securify.security.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserEService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User insertarUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void eliminarUser(Long user_id) {
        if(userRepository.existsById(user_id)) {
            userRepository.deleteById(user_id);
        }

    }

    @Transactional
    @Override
    public User modificarUser(User user) {
        if(userRepository.findById(user.getId()).isPresent()){
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public List<User> listarUser() {
        return userRepository.findAll();
    }

    @Override
    public User buscarUserPorId(long user_id) {
        if(userRepository.findById(user_id).isPresent()){
            return userRepository.findById(user_id).get();
        }
        return null;
    }
}
