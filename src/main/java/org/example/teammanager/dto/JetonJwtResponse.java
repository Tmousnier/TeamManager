package org.example.teammanager.dto;

public class JetonJwtResponse {
    public String token;
    public String email;
    public String role;

    public JetonJwtResponse(String token, String email, String role) {
        this.token = token;
        this.email = email;
        this.role = role;
    }
}