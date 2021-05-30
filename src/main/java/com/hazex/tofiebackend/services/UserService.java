package com.hazex.tofiebackend.services;

import com.hazex.tofiebackend.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserService extends MongoRepository<User,String> {
    User findByEmail(String email);
}
