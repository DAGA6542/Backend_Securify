package com.example.backend_securify.services;

import com.example.backend_securify.dtos.TiendaDTO;
import com.example.backend_securify.entities.Tienda;
import com.example.backend_securify.interfaces.ITiendaService;
import com.example.backend_securify.repositories.ITiendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TiendaService implements ITiendaService {

    @Autowired
    private ITiendaRepository ITiendaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TiendaDTO> listar() {
        return ITiendaRepository.findAll()
                .stream()
                .map((element) -> modelMapper.map(element, TiendaDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public TiendaDTO actualizarTienda(Long id_tienda, TiendaDTO tienda) {
        Tienda t = ITiendaRepository.findById((id_tienda)).get();
        modelMapper.map(tienda, t);
        Tienda tiendaActualizada = ITiendaRepository.save(t);
        return modelMapper.map(tiendaActualizada, TiendaDTO.class);
    }



    @Override
    public TiendaDTO guardarTienda(TiendaDTO tienda) {
        Tienda t = modelMapper.map(tienda, Tienda.class);
        Tienda save = ITiendaRepository.save(t);
        return modelMapper.map(save, TiendaDTO.class);
    }


    @Override
    public void eliminar(Long id_tienda) {
        if (ITiendaRepository.existsById((id_tienda))){
            ITiendaRepository.deleteById((id_tienda));
        }

    }

}
