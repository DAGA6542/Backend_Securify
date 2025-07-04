package com.example.backend_securify.services;

import com.example.backend_securify.entities.Tienda;
import com.example.backend_securify.interfaces.ITiendaService;
import com.example.backend_securify.repositories.ITiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiendaService implements ITiendaService {

    @Autowired
    private ITiendaRepository tiendaRepository;

    @Override
    public Tienda insertarTienda(Tienda tienda) {
        return tiendaRepository.save(tienda);
    }

    @Override
    public void eliminarTienda(Long tienda_id) {
        if (tiendaRepository.existsById(tienda_id)) {
            tiendaRepository.deleteById(tienda_id);
        }
    }

    @Override
    public Tienda modificarTienda(Tienda tienda) {
        if(tiendaRepository.findById(tienda.getTienda_id()).isPresent()){
            return tiendaRepository.save(tienda);
        }
        return null;
    }

    @Override
    public List<Tienda> listarTienda() {
        return tiendaRepository.findAll();
    }

    @Override
    public Tienda buscarTiendaPorId(long tienda_id) {
        if(tiendaRepository.findById(tienda_id).isPresent()){
            return tiendaRepository.findById(tienda_id).get();
        }
        return null;
    }
}