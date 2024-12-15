//package ma.projet.mobile.ProjetRecherche.entities;
//
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.time.LocalDate;
//
//@Data
//@Entity
//@Table(name = "reservation")
//public class Reservation {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "client_id")
//    private Client client;
//
//    @ManyToOne
//    @JoinColumn(name = "chambre_id")
//    private Chambre chambre;
//
//    private LocalDate dateDebut;
//    private LocalDate dateFin;
//    private String preferences;
//
//
//
//}

package ma.projet.mobile.ProjetRecherche.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;

    private String dateDebut; // Changer LocalDate en String
    private String dateFin;   // Changer LocalDate en String
    private String preferences;
}