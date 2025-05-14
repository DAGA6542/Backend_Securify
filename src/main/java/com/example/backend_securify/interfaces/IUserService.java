package com.example.backend_securify.interfaces;

import com.example.backend_securify.security.entities.User;

import java.util.List;

public interface IUserService {
    public User insertar(User usuario);
    public User editar(User usuario);
    public void eliminar(long id);
    public List<User> listar();
    public User buscarPorId(long id);
}
