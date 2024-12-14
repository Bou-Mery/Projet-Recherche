package ma.projet.mobile.ProjetRecherche.ws;

import ma.projet.mobile.ProjetRecherche.entities.Client;
import ma.projet.mobile.ProjetRecherche.services.ClientService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService(serviceName = "ClientWS")
public class ClientSoapService {

    @Autowired
    private ClientService clientService;

    @WebMethod
    public List<Client> getClients() {
        return clientService.findAll();
    }

    @WebMethod
    public Client getClientById(@WebParam(name = "id") Long id) {
        return clientService.findById(id);
    }

    @WebMethod
    public Client createClient(@WebParam(name = "client") Client client) {
        return clientService.save(client);
    }

    @WebMethod
    public boolean deleteClient(@WebParam(name = "id") Long id) {
        return clientService.deleteById(id);
    }
}