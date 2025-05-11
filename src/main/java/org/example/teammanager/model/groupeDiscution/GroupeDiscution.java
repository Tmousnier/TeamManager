package org.example.teammanager.model.groupeDiscution;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.groupeDiscutionMessage.GroupeDiscutionMessage;

import java.util.List;

@Entity
@Table(name = "groupe_discution")
@Data
@NoArgsConstructor
public class GroupeDiscution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom_groupe")
    private String nomGroupe;

    @OneToMany(mappedBy = "groupeDiscussion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GroupeDiscutionMessage> groupeDiscussionMessages;
}