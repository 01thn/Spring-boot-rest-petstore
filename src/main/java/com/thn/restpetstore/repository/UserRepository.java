package com.thn.restpetstore.repository;

import com.thn.restpetstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String username);

    void deleteByUsername(String username);
}
