package ma.projet.mobile.ProjetRecherche.soap;

import ma.projet.mobile.ProjetRecherche.entities.Utilisateur;
import ma.projet.mobile.ProjetRecherche.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UtilisateurSoapController {
    private static final String NAMESPACE_URI = "http://projet.mobile.ma/soap";

    @Autowired
    private UtilisateurService utilisateurService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUtilisateurRequest")
    @ResponsePayload
    public GetUtilisateurResponse getUtilisateur(@RequestPayload GetUtilisateurRequest request) {
        GetUtilisateurResponse response = new GetUtilisateurResponse();
        Utilisateur utilisateur = utilisateurService.findById(request.getId());
        response.setUtilisateur(utilisateur);
        return response;
    }
}