package org.example.teammanager.dto;

public class JetonJwtResponse {
    public String token;
    public String email;
    public String role;
    public String clubName;
    public String equipeName;

    public JetonJwtResponse(String token, String email, String role, String clubName, String equipeName) {
        this.token = token;
        this.email = email;
        this.role = role;
        this.clubName = clubName;
        this.equipeName = equipeName;
    }
}