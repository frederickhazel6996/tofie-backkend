package com.hazex.tofiebackend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection="admins")
public class Admin {

    @Id
    private String id;

    @Size(min=3,message = "Name Should be At least 3 characters")
    private String firstName;

    @Size(min=8,message = "Password Should be At least 8 characters")
    private String password;

    @Size(min=3,message = "Name Should be At least 3 characters")
    private String lastName;

    @Email
    @NotBlank
    private String email;
    private int accessLevel;//0 means superadmin, 1 means admin

    public Admin(String id, @Size(min = 3, message = "Name Should be At least 10 characters") String firstName, @Size(min = 8, message = "Password Should be At least 8 characters") String password, @Size(min = 3, message = "Name Should be At least 3 characters") String lastName, @Email @NotBlank String email, int accessLevel) {
        this.id = id;
        this.firstName = firstName;
        this.password = password;
        this.lastName = lastName;
        this.email = email;
        this.accessLevel = accessLevel;
    }

    public Admin()
    {

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

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", accessLevel=" + accessLevel +
                '}';
    }
}
