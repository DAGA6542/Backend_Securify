package com.example.backend_securify.repositories;

import com.example.backend_securify.dtos.UserDTO;
import com.example.backend_securify.entities.Tienda;
import com.example.backend_securify.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {

}
