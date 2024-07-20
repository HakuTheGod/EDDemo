package com.example.EDDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EDDemo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
