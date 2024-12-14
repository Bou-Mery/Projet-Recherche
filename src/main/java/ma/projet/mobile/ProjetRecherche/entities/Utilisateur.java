package ma.projet.mobile.ProjetRecherche.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomUtilisateur;
    private String motDePasse;
    private String role;

}