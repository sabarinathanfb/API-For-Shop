package com.store.UserService.repositories;

import com.store.UserService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
//    Optional<User> findByEmailOrUsername(String email, String username);

}
