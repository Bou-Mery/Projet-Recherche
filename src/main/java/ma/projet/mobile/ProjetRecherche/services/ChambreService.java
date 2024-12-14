package ma.projet.mobile.ProjetRecherche.services;

import ma.projet.mobile.ProjetRecherche.entities.Chambre;
import ma.projet.mobile.ProjetRecherche .repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreService {
    @Autowired
    private ChambreRepository chambreRepository;

    public List<Chambre> findAll() {
        return chambreRepository.findAll();
    }

    public Chambre findById(Long id) {
        return chambreRepository.findById(id).orElse(null);
    }

    public Chambre save(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public void delete(Long id) {
        chambreRepository.deleteById(id);
    }
}