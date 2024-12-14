package ma.projet.mobile.ProjetRecherche.config;

import ma.projet.mobile.ProjetRecherche.ws.ClientSoapService;
import ma.projet.mobile.ProjetRecherche.ws.ChambreSoapService;
import ma.projet.mobile.ProjetRecherche.ws.ReservationSoapService;
import ma.projet.mobile.ProjetRecherche.ws.UtilisateurSoapService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfig {

    private final ClientSoapService clientSoapService;
    private final ChambreSoapService chambreSoapService;
    private final ReservationSoapService reservationSoapService;
    private final UtilisateurSoapService utilisateurSoapService;
    private final Bus bus;

    public CxfConfig(ClientSoapService clientSoapService, ChambreSoapService chambreSoapService,
                     ReservationSoapService reservationSoapService, UtilisateurSoapService utilisateurSoapService,
                     Bus bus) {
        this.clientSoapService = clientSoapService;
        this.chambreSoapService = chambreSoapService;
        this.reservationSoapService = reservationSoapService;
        this.utilisateurSoapService = utilisateurSoapService;
        this.bus = bus;
    }

    @Bean
    public EndpointImpl clientEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, clientSoapService);
        endpoint.publish("/clients");
        return endpoint;
    }

    @Bean
    public EndpointImpl chambreEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, chambreSoapService);
        endpoint.publish("/chambres");
        return endpoint;
    }

    @Bean
    public EndpointImpl reservationEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, reservationSoapService);
        endpoint.publish("/reservations");
        return endpoint;
    }

    @Bean
    public EndpointImpl utilisateurEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, utilisateurSoapService);
        endpoint.publish("/utilisateurs");
        return endpoint;
    }
}