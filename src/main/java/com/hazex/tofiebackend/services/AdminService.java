package com.hazex.tofiebackend.services;

import com.hazex.tofiebackend.entities.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AdminService  extends MongoRepository <Admin,String> {

    Admin findByEmail(String email);


}
