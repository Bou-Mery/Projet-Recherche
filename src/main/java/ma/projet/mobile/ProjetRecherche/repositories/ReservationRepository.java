package ma.projet.mobile.ProjetRecherche.repositories;

import ma.projet.mobile.ProjetRecherche.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}