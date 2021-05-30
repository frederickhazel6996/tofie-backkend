package com.hazex.tofiebackend.services;

import com.hazex.tofiebackend.entities.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentService extends MongoRepository<Payment,String> {

    Payment findByAgentEmail(String email);
    Payment findByPaymentApiReference(String reference);

}
