package com.example.miaprimaapplicazione;

public class Risposta {
    private String token;
    private String role;
    private String user;

    public Risposta(String token, String role, String user) {
        this.token = token;
        this.role = role;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public String getRole() {
        return role;
    }

    public String getUser() {
        return user;
    }
}
