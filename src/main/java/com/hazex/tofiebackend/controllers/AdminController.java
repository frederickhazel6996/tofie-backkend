package com.hazex.tofiebackend.controllers;

import com.hazex.tofiebackend.entities.Admin;
import com.hazex.tofiebackend.extra.IdGenerator;
import com.hazex.tofiebackend.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    AdminService service;

    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder(10);

    @PostMapping(path="/add-admin")
    public ResponseEntity<String> addAdmin(@Valid @RequestBody Admin admin)
    {
        Admin adminData=service.findByEmail(admin.getEmail());

        if(adminData==null)
        {IdGenerator idGenerator=new IdGenerator();
        String id= "ADMIN"+idGenerator.getAlphaNumericString(15);
        admin.setId(id);
        admin.setEmail(admin.getEmail().toLowerCase());
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        service.save(admin);

        return new ResponseEntity<>("Admin "+ admin.getEmail()+ " Added", HttpStatus.CREATED);
        }

        else{
              return new ResponseEntity<>("Admin with email " +admin.getEmail()+ " exists", HttpStatus.OK);
        }

    }

    @GetMapping(path = "/get-admins")
    public ResponseEntity<Object> getAdmins()
    {

       List<Admin> newAdmin=service.findAll();

       return new ResponseEntity<>(newAdmin,HttpStatus.OK);
    }


    @PostMapping(path="/update-admin")

    public ResponseEntity<Object> updateAdmin(@Valid @RequestBody Admin admin)
    {
      Admin adminData=service.findByEmail(admin.getEmail().toLowerCase());

      if(adminData==null)
      {
          return new ResponseEntity<>("Admin Not Found", HttpStatus.NOT_FOUND);
      }

      else {
          adminData.setAccessLevel(admin.getAccessLevel());
          service.save(adminData);
          return new ResponseEntity<>(adminData, HttpStatus.OK);
      }
    }

    @DeleteMapping(path="/delete-admin/{adminId}")

    public ResponseEntity<String> deleteAdmin(@PathVariable String adminId)
    {
        service.deleteById(adminId);
        return new ResponseEntity<>("Admin Deleted", HttpStatus.CREATED);
    }
}
