package com.hazex.tofiebackend.controllers;


import com.hazex.tofiebackend.entities.User;
import com.hazex.tofiebackend.extra.IdGenerator;
import com.hazex.tofiebackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping(path = "/add-user")
    ResponseEntity<String> addUser(@Valid @RequestBody User user)
    {
        User userData=service.findByEmail(user.getEmail().toLowerCase());
        if(userData==null)
        {
            IdGenerator idGenerator=new IdGenerator();
            String id= "USER"+idGenerator.getAlphaNumericString(15);
            user.setId(id);
            user.setEmail(user.getEmail().toLowerCase());
            service.save(user);
            return new ResponseEntity<>("User Added", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("User Exists", HttpStatus.OK);
        }

    }

    @PostMapping(path = "/update-user")
    ResponseEntity<Object> updateUser(@Valid @RequestBody User user)
    {

        User userData=service.findByEmail(user.getEmail().toLowerCase());
        userData.setNumber(user.getNumber());
        service.save(userData);
        return  new ResponseEntity<>(userData,HttpStatus.CREATED);

    }

    @GetMapping(path = "/get-users")
    ResponseEntity<Object> getUsers()
    {

        List<User> userData=service.findAll();
        return  new ResponseEntity<>(userData,HttpStatus.OK);
    }

    @DeleteMapping(path ="/delete-user/{id}")
    ResponseEntity<String> deleteUser(@PathVariable String id)
    {
        service.deleteById(id);
        return new ResponseEntity<>("User Deleted",HttpStatus.OK);
    }
}
