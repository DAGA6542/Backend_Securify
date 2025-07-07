package com.example.backend_securify.services;
import com.example.backend_securify.dtos.UserDTO;
import com.example.backend_securify.interfaces.IUserService;
import com.example.backend_securify.repositories.IUserRepository;
import com.example.backend_securify.security.entities.User;
import com.example.backend_securify.security.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEService implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User insertarUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public void eliminarUser(Long user_id) {
        if (userRepository.existsById(user_id)) {
            userRepository.deleteById(user_id);
        }
    }


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

    //adap

    @Override
    public UserDTO insertar(UserDTO userdto) {
        //Convertir el DTO en Entidad
        User proveedorEntidad = modelMapper.map(userdto, User.class);
        User guardado = userRepository.save(proveedorEntidad);
        return modelMapper.map(guardado, UserDTO.class);
    }


    @Override
    public void eliminar(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
    }

}

