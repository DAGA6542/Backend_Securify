package com.example.backend_securify.controllers;

import com.example.backend_securify.dtos.UserDTO;
import com.example.backend_securify.security.entities.User;
import com.example.backend_securify.security.services.UserService;
import com.example.backend_securify.services.UserEService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", exposedHeaders = "Authorization") //para cloud
@RequestMapping("/user")

public class UserEController {

    @Autowired
    private UserEService userService;

    @PostMapping("/insertaruser") //End Point
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> insertarUser(@RequestBody User user) {
        User userRe = userService.insertarUser(user);
        return new ResponseEntity<>(userRe, HttpStatus.OK);
    }

    @GetMapping("/listausers") //End Point
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDTO> listarUser() {
        List<User> users = userService.listarUser();
        ModelMapper modelMapper = new ModelMapper();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping("/actualizaruser")
    @PreAuthorize("hasRole('ADMIN')")
    public void actualizarUser(@RequestBody UserDTO userdto) {
        ModelMapper m = new ModelMapper();
        User user = m.map(userdto, User.class);
        userService.modificarUser(user);
    }

    @DeleteMapping("/eliminaruser/{id}")
    public ResponseEntity<Void> eliminarUser(@RequestParam Long user_id) {
        userService.eliminarUser(user_id);
        return ResponseEntity.noContent().build();
    }

    //Adap

    @PostMapping("/postuser")
    public ResponseEntity<UserDTO> registrarUser(@RequestBody UserDTO userdto) throws Exception {
        return ResponseEntity.ok(userService.insertar(userdto));
    }

    @DeleteMapping("/deleteuser/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable Long id){
        userService.eliminar(id);
    }
}
