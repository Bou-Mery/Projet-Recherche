package ma.projet.mobile.ProjetRecherche.soap;

import ma.projet.mobile.ProjetRecherche.entities.Chambre;
import ma.projet.mobile.ProjetRecherche.services.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ChambreSoapController {
    private static final String NAMESPACE_URI = "http://projet.mobile.ma/soap";

    @Autowired
    private ChambreService chambreService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetChambreRequest")
    @ResponsePayload
    public GetChambreResponse getChambre(@RequestPayload GetChambreRequest request) {
        GetChambreResponse response = new GetChambreResponse();
        Chambre chambre = chambreService.findById(request.getId());
        response.setChambre(chambre);
        return response;
    }
}