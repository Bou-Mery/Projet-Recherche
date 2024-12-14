package ma.projet.mobile.ProjetRecherche.repositories;

import ma.projet.mobile.ProjetRecherche.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
