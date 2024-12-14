package ma.projet.mobile.ProjetRecherche.ws;

import ma.projet.mobile.ProjetRecherche.entities.Utilisateur;
import ma.projet.mobile.ProjetRecherche.services.UtilisateurService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService(serviceName = "UtilisateurWS")
public class UtilisateurSoapService {

    @Autowired
    private UtilisateurService utilisateurService;

    @WebMethod
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurService.findAll();
    }

    @WebMethod
    public Utilisateur getUtilisateurById(@WebParam(name = "id") Long id) {
        return utilisateurService.findById(id);
    }

    @WebMethod
    public Utilisateur createUtilisateur(@WebParam(name = "utilisateur") Utilisateur utilisateur) {
        return utilisateurService.save(utilisateur);
    }

    @WebMethod
    public boolean deleteUtilisateur(@WebParam(name = "id") Long id) {
        return utilisateurService.deleteById(id);
    }
}