package org.example.teammanager.dto.contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Email
public class ContactDto {

    @NotEmpty(message = "Le nom ne peut pas être vide")
    private String nom;

    @NotEmpty(message = "Le prénom ne peut pas être vide")
    private String prenom;

    @NotEmpty(message = "L'email ne peut pas être vide")
    @Email(message = "L'email doit être valide")
    private String email;

    @NotEmpty(message = "Le sujet ne peut pas être vide")
    private String sujet;

    @NotEmpty(message = "Le message ne peut pas être vide")
    private String message;
}