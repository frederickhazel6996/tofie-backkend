package com.hazex.tofiebackend.services;

import com.hazex.tofiebackend.entities.Agent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgentService extends MongoRepository<Agent,String> {
    Agent findByEmail(String email);
    Agent findByMobileNumber(String mobileNumber);
}
