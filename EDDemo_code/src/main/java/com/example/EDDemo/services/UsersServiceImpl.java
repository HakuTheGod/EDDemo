package com.example.EDDemo.services;

import java.util.List;

import com.example.EDDemo.entities.User;
import com.example.EDDemo.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EDDemo.repositories.UserRepository;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    public UsersServiceImpl(UserRepository userRespository) {
        super();
        this.userRepository = userRespository;
    }

    @Override
    public User saveUser(User user) {
        if (user.getAddresses() != null) {
            user.getAddresses().forEach(address -> address.setUser(user));
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId.toString()));
        userRepository.delete(user);
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId.toString()));
    }

    // @Override
    // public User updateUser(User user, Integer userId) {
    //     private String
    //     if (userRepository.existsById(userId)) {
    //         user.setId(userId);

    //         User existingUser = userRepository.findById(userId)
    //     .orElseThrow(() -> new RuntimeException("User not found"));

    //     if (user.getName() != null) {
    //         existingUser.setName(user.getName());
    //     }
    //     if (user.getSurname() != null) {
    //         existingUser.setSurname(user.getSurname());
    //     }
    //     if (user.getGender() != null) {
    //         existingUser.setGender(user.getGender());
    //     }
    //     if (user.getBirthDate() != null) {
    //         existingUser.setBirthDate(user.getBirthDate());
    //     }
    //         return userRepository.save(user);
    //     } else {
    //         throw new RuntimeException("User not found with ID: " + userId);
    //     }
    // }
}
