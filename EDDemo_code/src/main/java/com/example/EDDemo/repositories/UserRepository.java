package com.example.EDDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EDDemo.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
