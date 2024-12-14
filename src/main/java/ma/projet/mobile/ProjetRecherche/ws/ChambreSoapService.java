package ma.projet.mobile.ProjetRecherche.ws;

import ma.projet.mobile.ProjetRecherche.entities.Chambre;
import ma.projet.mobile.ProjetRecherche.services.ChambreService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService(serviceName = "ChambreWS")
public class ChambreSoapService {

    @Autowired
    private ChambreService chambreService;

    @WebMethod
    public List<Chambre> getChambres() {
        return chambreService.findAll();
    }

    @WebMethod
    public Chambre getChambreById(@WebParam(name = "id") Long id) {
        return chambreService.findById(id);
    }

    @WebMethod
    public Chambre createChambre(@WebParam(name = "chambre") Chambre chambre) {
        return chambreService.save(chambre);
    }

    @WebMethod
    public boolean deleteChambre(@WebParam(name = "id") Long id) {
        return chambreService.deleteById(id);
    }
}