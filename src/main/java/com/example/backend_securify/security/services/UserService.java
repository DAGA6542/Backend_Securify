package com.example.backend_securify.security.services;


import com.example.backend_securify.security.entities.User;
import com.example.backend_securify.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    public Integer insertUserRol(Long user_id, Long rol_id) {
        Integer result = 0;
        userRepository.insertUserRol(user_id, rol_id);
        return 1;
    }
    public List<User> findUsersByRoleId(@Param("roleId") Long roleId) {
        return userRepository.findUsersByRoleId(roleId);
    }

}
