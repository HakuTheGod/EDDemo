package com.example.EDDemo.controllers;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EDDemo.services.UsersService;
import com.example.EDDemo.entities.User;

@RestController
public class UsersController {

        public UsersService userService;

        public UsersController(UsersService usersService){
            super();
            this.userService = usersService;
        } 

        @RequestMapping(value = "/api/user", method = RequestMethod.POST)
        @ResponseBody
        public ResponseEntity<User> saveUser(@RequestBody User user){
            User savedUser = userService.saveUser(user);
            return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
        }

        @RequestMapping(value = "/api/users", method = RequestMethod.GET)
        @ResponseBody
        public List<User> getAllUsers(){
            return userService.getAllUsers();
        }
}