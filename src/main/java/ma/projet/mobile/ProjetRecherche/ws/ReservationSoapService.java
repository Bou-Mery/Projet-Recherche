package ma.projet.mobile.ProjetRecherche.ws;

import ma.projet.mobile.ProjetRecherche.entities.Reservation;
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
        return reservationService.save(reservation);
    }

    @WebMethod
    public boolean deleteReservation(@WebParam(name = "id") Long id) {
        return reservationService.deleteById(id);
    }
}