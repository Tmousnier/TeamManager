package org.example.teammanager.model.roleMembre;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "role_membre")// Make sure table name matches your DB
@Data
public class RoleMembre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomRole;
}