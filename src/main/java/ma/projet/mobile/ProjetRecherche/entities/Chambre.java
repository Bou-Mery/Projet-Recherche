package ma.projet.mobile.ProjetRecherche.entities;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@Entity
@XmlRootElement(name = "chambre") // Assurez-vous que le nom correspond à ce qui est attendu
@Table(name = "chambre")
public class Chambre{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double prix;
    private boolean disponible;

    // Getters et Setters (générés par Lombok avec @Data)
}