package com.hazex.tofiebackend.entities;

public class LoginResponse {

    private final String JWT;
    private String adminName;

    public LoginResponse(String JWT, String adminName) {
        this.JWT = JWT;
        this.adminName = adminName;
    }


    public String getJWT() {
        return JWT;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
