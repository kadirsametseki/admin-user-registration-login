package com.example.adminuserregistrationlogin.repository;

import com.example.adminuserregistrationlogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}