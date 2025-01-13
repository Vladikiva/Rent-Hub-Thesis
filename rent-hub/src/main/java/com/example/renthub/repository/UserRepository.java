package com.example.renthub.repository;

import com.example.renthub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // Поиск пользователя по имени
    User findByEmail(String email); // Поиск пользователя по email
}
