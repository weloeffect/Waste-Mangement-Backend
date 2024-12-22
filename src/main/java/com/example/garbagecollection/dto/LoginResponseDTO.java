package com.example.garbagecollection.dto;


public class LoginResponseDTO {
    private String token;
    private UserRequestDTO user;
    private String email;
    private String password;

    // Getters and setters

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserRequestDTO getUser() {
        return user;
    }

    public void setUser(UserRequestDTO user) {
        this.user = user;
    }
}
