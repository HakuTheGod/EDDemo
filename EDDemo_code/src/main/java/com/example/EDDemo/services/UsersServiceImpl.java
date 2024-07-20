package com.example.EDDemo.services;

import com.example.EDDemo.entities.Address;
import com.example.EDDemo.entities.User;
import com.example.EDDemo.exceptions.ResourceNotFoundException;
import com.example.EDDemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    public UsersServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        try {
            if (user.getAddresses() != null) {
                user.getAddresses().forEach(address -> address.setUser(user));
            }
            return userRepository.save(user); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteUser(Long userId) {
        try {
            User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId.toString()));
            userRepository.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(Long userId) {
        try {
            return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User updateUser(User user){
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
