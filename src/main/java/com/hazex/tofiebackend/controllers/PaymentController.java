package com.hazex.tofiebackend.controllers;


import com.hazex.tofiebackend.entities.Payment;
import com.hazex.tofiebackend.extra.IdGenerator;
import com.hazex.tofiebackend.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/payment")
public class PaymentController {
    @Autowired
    PaymentService service;

    @PostMapping(path = "/add-payment")
    public ResponseEntity<String> addPayment(@Valid  @RequestBody Payment payment)
    {

        IdGenerator idGenerator=new IdGenerator();
        String id= "PAYMENT"+idGenerator.getAlphaNumericString(15);
        LocalDateTime timePoint = LocalDateTime.now();
        payment.setId(id);
        payment.setPaymentDate(timePoint);

        service.save(payment);

        return new ResponseEntity<>("Payment Added", HttpStatus.CREATED);
    }

    @GetMapping(path = "/get-payments")
    public ResponseEntity<Object> getPayments()
    {   List<Payment> payments=service.findAll();
        return  new ResponseEntity<>(payments,HttpStatus.OK);
    }

    @PostMapping(path = "/confirm-payment")
    public ResponseEntity<Object> confirmPayments(@Valid @RequestBody Payment payment)
    {
        Payment paymentData= service.findByPaymentApiReference(payment.getPaymentApiReference());
        paymentData.setPaymentStatus(1);
        service.save(paymentData);
        return new ResponseEntity<>(paymentData,HttpStatus.CREATED);
    }

    @DeleteMapping(path="/delete-payment/{id}")
    public  ResponseEntity<String> deletePayment(@PathVariable String id)
    {

        service.deleteById(id);
        return  new ResponseEntity<>("Payment Deleted",HttpStatus.CREATED);
    }

}
