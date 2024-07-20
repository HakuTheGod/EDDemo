package com.example.EDDemo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.EDDemo.services.UsersService;
import com.example.EDDemo.entities.User;

@RestController
public class UsersController {

    @Autowired
    public UsersService userService;

    public UsersController(UsersService usersService) {
        super();
        this.userService = usersService;
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build(); 
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // @RequestMapping(value = "/api/user/{id}", method = RequestMethod.PUT)
    // @ResponseBody
    // public ResponseEntity<User> updateUser(
    //         @RequestBody User user, 
    //         @PathVariable Integer id) {
    //     try {
    //         User updatedUser = userService.updateUser(user, id);
    //         return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    //     } catch (RuntimeException e) {
    //         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    //     }
    // }
}