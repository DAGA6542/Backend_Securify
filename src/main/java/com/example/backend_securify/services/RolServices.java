package com.example.backend_securify.services;

import com.example.backend_securify.dtos.RolDto;
import com.example.backend_securify.entities.Rol;
import com.example.backend_securify.interfaces.IRolService;
import com.example.backend_securify.repositories.RolRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolServices implements IRolService {

    @Autowired // inyecta
    private RolRepository rolRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RolDto> listarRol() {
        return rolRepository.findAll().stream().map(rol -> modelMapper.map(rol, RolDto.class)).collect(Collectors.toList());
    }

    @Override
    public RolDto guardarRol(RolDto rol) {
        Rol r = modelMapper.map(rol, Rol.class);
        Rol save = rolRepository.save(r);
        return modelMapper.map(save, RolDto.class);
    }


    @Override
    public RolDto ActualizarRol(Long idRol, RolDto rolDto) {
        Rol r = rolRepository.findById(idRol).get();
        modelMapper.map(rolDto, r);
        Rol rolActualizado = rolRepository.save(r);
        return modelMapper.map(rolActualizado, RolDto.class);
    }


    @Override
    public void EliminarRol(Long idRol) {
        if (rolRepository.existsById(idRol)) {
            rolRepository.deleteById(idRol);
        }
    }
}
