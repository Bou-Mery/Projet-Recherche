package ma.projet.mobile.ProjetRecherche.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "chambre")
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double prix;
    private boolean disponible;


}