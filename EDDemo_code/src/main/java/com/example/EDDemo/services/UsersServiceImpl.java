package com.example.EDDemo.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.EDDemo.entities.User;
import com.example.EDDemo.repositories.UserRepository;

@Service
public class UsersServiceImpl implements UsersService {

    private UserRepository userRepository;

    public UsersServiceImpl(UserRepository userRespository){
        super();
        this.userRepository = userRespository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    
    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
