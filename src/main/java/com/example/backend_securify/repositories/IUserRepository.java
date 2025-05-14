package com.example.backend_securify.repositories;

import com.example.backend_securify.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
