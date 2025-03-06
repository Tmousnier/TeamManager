package org.example.teammanager.model.membre;

// ... (imports)

import lombok.*;
import org.example.teammanager.model.membreRoleMembre.MembreRoleMembre;
import org.example.teammanager.model.roleMembre.RoleMembre; // Import RoleMembre

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private String genre;
    private LocalDate dateDeNaissance;
    private String email;
    private Integer numeroTelephone;
    private String password;
    private Date dateInscription;



    @OneToMany(mappedBy = "idMembre", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MembreRoleMembre> membreRoleMembres;


    public Collection<RoleMembre> getRoles() {
        if (membreRoleMembres == null) {
            return List.of(); // or Collections.emptyList()
        }
        return membreRoleMembres.stream()
                .map(MembreRoleMembre::getIdRoleMembre)
                .collect(Collectors.toList());
    }
}