package com.example.backend_securify.security.repositories;
import com.example.backend_securify.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
