package com.hazex.tofiebackend.controllers;


import com.hazex.tofiebackend.entities.Property;
import com.hazex.tofiebackend.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/property")
public class PropertyController {

    @Autowired
    PropertyService service;

    @GetMapping (path = "/get-properties")
    ResponseEntity<Object> getProperties()
    {
        List<Property> propertyData=service.findAll();
        return new ResponseEntity<>(propertyData, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete-property/{id}")
    ResponseEntity<String> deleteProperty(@PathVariable String id)
    {
        service.deleteById(id);
        return new ResponseEntity<>("Property Deleted",HttpStatus.CREATED);
    }
}
