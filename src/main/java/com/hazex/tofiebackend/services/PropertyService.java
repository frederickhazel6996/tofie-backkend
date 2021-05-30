package com.hazex.tofiebackend.services;

import com.hazex.tofiebackend.entities.Property;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PropertyService extends MongoRepository<Property,String> {
}
