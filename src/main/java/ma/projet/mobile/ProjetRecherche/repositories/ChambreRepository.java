package ma.projet.mobile.ProjetRecherche.repositories;

import ma.projet.mobile.ProjetRecherche.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}