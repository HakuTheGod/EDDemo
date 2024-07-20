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
        try {
            User savedUser = userService.saveUser(user);
            return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        try {
            return userService.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok().build(); 
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        try {
            User updateUser = userService.getUserById(id);
            if(updateUser == null){
                return ResponseEntity.notFound().build();
            }
            updateUser.setId(id);
            if(user.getName() != null){
              updateUser.setName(user.getName());  
            }
            if(user.getSurname() != null){
                updateUser.setSurname(user.getSurname());
            }
            if(user.getBirthDate() != null){
                updateUser.setBirthDate(user.getBirthDate());
            }
            if(user.getGender() != null){
                if(!user.getGender().equals("male") && !user.getGender().equals("female") && !user.getGender().equals("other")){
                    throw new Exception("Invalid Gender");
                }
                updateUser.setGender(user.getGender());
            }
            userService.updateUser(updateUser);
            return ResponseEntity.ok(updateUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
