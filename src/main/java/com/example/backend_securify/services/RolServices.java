package com.example.backend_securify.services;

import com.example.backend_securify.dtos.RolDTO;
import com.example.backend_securify.entities.Rol;
import com.example.backend_securify.interfaces.IRolService;
import com.example.backend_securify.repositories.IRolRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolServices implements IRolService {

    @Autowired // inyecta
    private IRolRepository IRolRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RolDTO> listarRol() {
        return IRolRepository.findAll().stream().map(rol -> modelMapper.map(rol, RolDTO.class)).collect(Collectors.toList());
    }

    @Override
    public RolDTO guardarRol(RolDTO rol) {
        Rol r = modelMapper.map(rol, Rol.class);
        Rol save = IRolRepository.save(r);
        return modelMapper.map(save, RolDTO.class);
    }


    @Override
    public RolDTO ActualizarRol(Long idRol, RolDTO rolDto) {
        Rol r = IRolRepository.findById(idRol).get();
        modelMapper.map(rolDto, r);
        Rol rolActualizado = IRolRepository.save(r);
        return modelMapper.map(rolActualizado, RolDTO.class);
    }


    @Override
    public void EliminarRol(Long idRol) {
        if (IRolRepository.existsById(idRol)) {
            IRolRepository.deleteById(idRol);
        }
    }
}
