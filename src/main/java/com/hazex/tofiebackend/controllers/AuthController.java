package com.hazex.tofiebackend.controllers;


import com.hazex.tofiebackend.config.JWT.JWTUtil;
import com.hazex.tofiebackend.entities.Admin;
import com.hazex.tofiebackend.entities.LoginRequest;
import com.hazex.tofiebackend.entities.LoginResponse;
import com.hazex.tofiebackend.services.AdminService;
import com.hazex.tofiebackend.services.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    AdminService service;

    @Autowired
    AdminUserService userService;

    @Autowired
    JWTUtil jwtService;
    @PostMapping(path = "/login")
    ResponseEntity<Object> LoginAdmin(@RequestBody LoginRequest request) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername().toLowerCase(), request.getPassword()));
        }
        catch (BadCredentialsException e)
        {
            throw new Exception("Incorrect Username",e);
        }
        Admin admin=service.findByEmail(request.getUsername().toLowerCase());
        System.out.println(admin);
        final UserDetails userDetails= userService.loadUserByUsername(request.getUsername().toLowerCase());
        final String jwt= jwtService.generateToken(userDetails);
        return  new ResponseEntity<>(new LoginResponse(jwt, admin.getFirstName()+" "+admin.getLastName()), HttpStatus.OK);
    }
}
