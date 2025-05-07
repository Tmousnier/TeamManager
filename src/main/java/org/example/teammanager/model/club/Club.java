package org.example.teammanager.model.club;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "club")
@Data // Lombok s'occupe des getters, setters, etc.
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "ville")
    private String ville;

    @Column(name = "addresse")
    private String addresse;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @Column(name = "description")
    private String description;

    @Column(name = "pays")
    private String pays;

    @Column(name = "numero_telephone")
    private String numeroTelephone;
}