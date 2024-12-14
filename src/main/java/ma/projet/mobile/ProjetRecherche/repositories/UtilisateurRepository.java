package ma.projet.mobile.ProjetRecherche.repositories;

import ma.projet.mobile.ProjetRecherche.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}