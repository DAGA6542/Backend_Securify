package com.example.backend_securify.interfaces;

import com.example.backend_securify.entities.Cliente;

import java.util.List;

public interface IClienteService {
    public Cliente insertar(Cliente cliente);
    public Cliente editar(Cliente cliente);
    public void eliminar(long id);
    public List<Cliente> listar();
    public Cliente buscarPorId(long id);
}
