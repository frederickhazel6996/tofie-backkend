package com.hazex.tofiebackend.services;

import com.hazex.tofiebackend.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminUserService implements UserDetailsService {
    @Autowired
    AdminService service;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException{

        Admin admin=service.findByEmail(s.toLowerCase());
        return new User(admin.getEmail().toLowerCase(), admin.getPassword(), new ArrayList<>());

    }
}
