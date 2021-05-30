package com.hazex.tofiebackend.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Document(collection = "agents")
public class Agent {

    @Id
    private String id;

    @Size(min=3,message = "Name Should be At least 3 characters")
    private String firstName;

    @Size(min=3,message = "Name Should be At least 3 characters")
    private String lastName;

    @Email
    @NotBlank
    private String email;
    private String profilePictureString;
    private int verified;
    private String mobileNumber;
    private String whatsappNumber;
    private String otherNumber;
    private String password;
    private String about;
    private String experience;
    private String rentCommissionPercentage;
    private String saleCommissionPercentage;
    private String agentVerificationDocumentsLink;
    private String registrationFee;
    private String locality;
    private String facebookLink;
    private String linkedinLink;
    private String websiteLink;
    private LocalDateTime dateAdded;
    private int agentType;

    public Agent()
    {

    }

    public Agent(String id, @Size(min = 3, message = "Name Should be At least 3 characters") String firstName, @Size(min = 3, message = "Name Should be At least 3 characters") String lastName, @Email @NotBlank String email, String profilePictureString, int verified, String mobileNumber, String whatsappNumber, String otherNumber, String password, String about, String experience, String rentCommissionPercentage, String saleCommissionPercentage, String agentVerificationDocumentsLink, String registrationFee, String locality, String facebookLink, String linkedinLink, String websiteLink, LocalDateTime dateAdded, int agentType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profilePictureString = profilePictureString;
        this.verified = verified;
        this.mobileNumber = mobileNumber;
        this.whatsappNumber = whatsappNumber;
        this.otherNumber = otherNumber;
        this.password = password;
        this.about = about;
        this.experience = experience;
        this.rentCommissionPercentage = rentCommissionPercentage;
        this.saleCommissionPercentage = saleCommissionPercentage;
        this.agentVerificationDocumentsLink = agentVerificationDocumentsLink;
        this.registrationFee = registrationFee;
        this.locality = locality;
        this.facebookLink = facebookLink;
        this.linkedinLink = linkedinLink;
        this.websiteLink = websiteLink;
        this.dateAdded = dateAdded;
        this.agentType = agentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePictureString() {
        return profilePictureString;
    }

    public void setProfilePictureString(String profilePictureString) {
        this.profilePictureString = profilePictureString;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getWhatsappNumber() {
        return whatsappNumber;
    }

    public void setWhatsappNumber(String whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }

    public String getOtherNumber() {
        return otherNumber;
    }

    public void setOtherNumber(String otherNumber) {
        this.otherNumber = otherNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getRentCommissionPercentage() {
        return rentCommissionPercentage;
    }

    public void setRentCommissionPercentage(String rentCommissionPercentage) {
        this.rentCommissionPercentage = rentCommissionPercentage;
    }

    public String getSaleCommissionPercentage() {
        return saleCommissionPercentage;
    }

    public void setSaleCommissionPercentage(String saleCommissionPercentage) {
        this.saleCommissionPercentage = saleCommissionPercentage;
    }

    public String getAgentVerificationDocumentsLink() {
        return agentVerificationDocumentsLink;
    }

    public void setAgentVerificationDocumentsLink(String agentVerificationDocumentsLink) {
        this.agentVerificationDocumentsLink = agentVerificationDocumentsLink;
    }

    public String getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(String registrationFee) {
        this.registrationFee = registrationFee;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public int getAgentType() {
        return agentType;
    }

    public void setAgentType(int agentType) {
        this.agentType = agentType;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", profilePictureString='" + profilePictureString + '\'' +
                ", verified=" + verified +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", whatsappNumber='" + whatsappNumber + '\'' +
                ", otherNumber='" + otherNumber + '\'' +
                ", password='" + password + '\'' +
                ", about='" + about + '\'' +
                ", experience='" + experience + '\'' +
                ", rentCommissionPercentage='" + rentCommissionPercentage + '\'' +
                ", saleCommissionPercentage='" + saleCommissionPercentage + '\'' +
                ", agentVerificationDocumentsLink='" + agentVerificationDocumentsLink + '\'' +
                ", registrationFee='" + registrationFee + '\'' +
                ", locality='" + locality + '\'' +
                ", facebookLink='" + facebookLink + '\'' +
                ", linkedinLink='" + linkedinLink + '\'' +
                ", websiteLink='" + websiteLink + '\'' +
                ", dateAdded=" + dateAdded +
                ", agentType=" + agentType +
                '}';
    }
}
