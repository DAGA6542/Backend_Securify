package com.example.backend_securify.interfaces;

import com.example.backend_securify.entities.Tienda;
import com.example.backend_securify.security.entities.User;

import java.util.List;

public interface IUserService {
    public User insertarUser(User user);
    public void eliminarUser(Long user_id);
    public User modificarUser(User user);
    public List<User> listarUser();
    public User buscarUserPorId(long user_id);
}
