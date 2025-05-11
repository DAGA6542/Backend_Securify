package com.example.backend_securify.services;

import com.example.backend_securify.dtos.TiendaDto;
import com.example.backend_securify.entities.Tienda;
import com.example.backend_securify.interfaces.ITienda;
import com.example.backend_securify.repositories.TiendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TiendaService implements ITienda {

    @Autowired
    private TiendaRepository tiendaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TiendaDto> listar() {
        return tiendaRepository.findAll()
                .stream()
                .map((element) -> modelMapper.map(element, TiendaDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public TiendaDto actualizarTienda(Long id_tienda, TiendaDto tienda) {
        Tienda t = tiendaRepository.findById((id_tienda)).get();
        modelMapper.map(tienda, t);
        Tienda tiendaActualizada = tiendaRepository.save(t);
        return modelMapper.map(tiendaActualizada, TiendaDto.class);
    }



    @Override
    public TiendaDto guardarTienda(TiendaDto tienda) {
        Tienda t = modelMapper.map(tienda, Tienda.class);
        Tienda save = tiendaRepository.save(t);
        return modelMapper.map(save, TiendaDto.class);
    }


    @Override
    public void eliminar(Long id_tienda) {
        if (tiendaRepository.existsById((id_tienda))){
            tiendaRepository.deleteById((id_tienda));
        }

    }

}
