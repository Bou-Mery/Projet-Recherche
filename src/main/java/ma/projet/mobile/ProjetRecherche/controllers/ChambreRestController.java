package ma.projet.mobile.ProjetRecherche.controllers;

import ma.projet.mobile.ProjetRecherche.entities.Chambre;
import ma.projet.mobile.ProjetRecherche.services.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chambres")
public class ChambreRestController {
    @Autowired
    private ChambreService chambreService;

    @GetMapping
    public List<Chambre> getAllChambres() {
        return chambreService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getChambreById(@PathVariable Long id) {
        Chambre chambre = chambreService.findById(id);
        return chambre != null ? ResponseEntity.ok(chambre) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Chambre createChambre(@RequestBody Chambre chambre) {
        return chambreService.save(chambre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChambre(@PathVariable Long id) {
        chambreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}