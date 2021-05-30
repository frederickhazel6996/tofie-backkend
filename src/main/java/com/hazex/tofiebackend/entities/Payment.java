package com.hazex.tofiebackend.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Document(collection = "payments")
public class Payment {

    @Id
    private String id;

    @Size(min=3,message = "Reference Should be At least 3 characters")
    private String paymentReference;

    @Size(min=3,message = "agentId Should be At least 3 characters")
    private String agentId;

    @Email
    @NotBlank
    private String agentEmail;


    private int paymentStatus;//0 means not paid, 1 means paid
    private LocalDateTime paymentDate;
    private String paymentAmount;
    private String paymentMethod;
    private int paymentCurrency;//0 means ghc, 1 means $,etc
    private String paymentReceiptLink;
    private String paymentApiReference;

    @Size(min=3,message = "Admin Id Should be At least 3 characters")
    private String adminId;

    public Payment()
    {

    }
    public Payment(String id, @Size(min = 3, message = "Reference Should be At least 3 characters") String paymentReference, @Size(min = 3, message = "agentId Should be At least 3 characters") String agentId, @Email @NotBlank String agentEmail, int paymentStatus, LocalDateTime paymentDate, String paymentAmount, String paymentMethod, int paymentCurrency, String paymentReceiptLink, String paymentApiReference, @Size(min = 3, message = "Admin Id Should be At least 3 characters") String adminId) {
        this.id = id;
        this.paymentReference = paymentReference;
        this.agentId = agentId;
        this.agentEmail = agentEmail;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.paymentCurrency = paymentCurrency;
        this.paymentReceiptLink = paymentReceiptLink;
        this.paymentApiReference = paymentApiReference;
        this.adminId = adminId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentCurrency() {
        return paymentCurrency;
    }

    public void setPaymentCurrency(int paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
    }

    public String getPaymentReceiptLink() {
        return paymentReceiptLink;
    }

    public void setPaymentReceiptLink(String paymentReceiptLink) {
        this.paymentReceiptLink = paymentReceiptLink;
    }

    public String getPaymentApiReference() {
        return paymentApiReference;
    }

    public void setPaymentApiReference(String paymentApiReference) {
        this.paymentApiReference = paymentApiReference;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "id='" + id + '\'' +
                ", paymentReference='" + paymentReference + '\'' +
                ", agentId='" + agentId + '\'' +
                ", agentEmail='" + agentEmail + '\'' +
                ", paymentStatus=" + paymentStatus +
                ", paymentDate=" + paymentDate +
                ", paymentAmount='" + paymentAmount + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentCurrency=" + paymentCurrency +
                ", paymentReceiptLink='" + paymentReceiptLink + '\'' +
                ", paymentApiReference='" + paymentApiReference + '\'' +
                ", adminId='" + adminId + '\'' +
                '}';
    }
}
