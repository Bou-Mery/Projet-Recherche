package ma.projet.mobile.ProjetRecherche.ws;

import ma.projet.mobile.ProjetRecherche.entities.Chambre;
import ma.projet.mobile.ProjetRecherche.entities.Client;
import ma.projet.mobile.ProjetRecherche.entities.Reservation;
import ma.projet.mobile.ProjetRecherche.services.ChambreService; // Assurez-vous d'importer le bon service
import ma.projet.mobile.ProjetRecherche.services.ClientService; // Assurez-vous d'importer le bon service
import ma.projet.mobile.ProjetRecherche.services.ReservationService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService(serviceName = "ReservationWS")
public class ReservationSoapService {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ClientService clientService; // Injection du service Client

    @Autowired
    private ChambreService chambreService; // Injection du service Chambre

    @WebMethod
    public List<Reservation> getReservations() {
        return reservationService.findAll();
    }

    @WebMethod
    public Reservation getReservationById(@WebParam(name = "id") Long id) {
        return reservationService.findById(id);
    }

    @WebMethod
    public Reservation createReservation(@WebParam(name = "reservation") Reservation reservation) {

        if (reservation.getClient() == null || reservation.getClient().getId() == null) {
            throw new IllegalArgumentException("Client ID is required");
        }
        if (reservation.getChambre() == null || reservation.getChambre().getId() == null) {
            throw new IllegalArgumentException("Chambre ID is required");
        }

        Client client = clientService.findById(reservation.getClient().getId());
        if (client == null) {
            throw new IllegalArgumentException("Client not found");
        }

        Chambre chambre = chambreService.findById(reservation.getChambre().getId());
        if (chambre == null) {
            throw new IllegalArgumentException("Chambre not found");
        }
        reservation.setClient(client);
        reservation.setChambre(chambre);

        return reservationService.save(reservation);
    }

    @WebMethod
    public boolean deleteReservation(@WebParam(name = "id") Long id) {
        return reservationService.deleteById(id);
    }
}