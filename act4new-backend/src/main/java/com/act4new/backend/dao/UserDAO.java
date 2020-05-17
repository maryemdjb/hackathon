package com.act4new.backend.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.act4new.backend.model.Users;

public interface UserDAO extends JpaRepository<Users,Long> {
    Optional<Users> findByUsername(String username);
    Optional<Users> findByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);


}
