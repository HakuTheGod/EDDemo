package com.example.EDDemo.services;

import java.util.List;
import com.example.EDDemo.entities.User;

public interface UsersService {

    User saveUser(User user);

    List<User> getAllUsers();

    void deleteUser(Long userId);

    User getUserById(Long userId);

    User updateUser(User user);
}
