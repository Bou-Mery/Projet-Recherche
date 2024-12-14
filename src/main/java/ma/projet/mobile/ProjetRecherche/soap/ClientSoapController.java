package ma.projet.mobile.ProjetRecherche.soap;

import ma.projet.mobile.ProjetRecherche.entities.Client;
import ma.projet.mobile.ProjetRecherche.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ClientSoapController {
    private static final String NAMESPACE_URI = "http://projet.mobile.ma/soap";

    @Autowired
    private ClientService clientService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetClientRequest")
    @ResponsePayload
    public GetClientResponse getClient(@RequestPayload GetClientRequest request) {
        GetClientResponse response = new GetClientResponse();
        Client client = clientService.findById(request.getId());
        response.setClient(client);
        return response;
    }
}