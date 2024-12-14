package ma.projet.mobile.ProjetRecherche.soap;

import ma.projet.mobile.ProjetRecherche.entities.Reservation;
import ma.projet.mobile.ProjetRecherche.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ReservationSoapController {
    private static final String NAMESPACE_URI = "http://projet.mobile.ma/soap";

    @Autowired
    private ReservationService reservationService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetReservationRequest")
    @ResponsePayload
    public GetReservationResponse getReservation(@RequestPayload GetReservationRequest request) {
        GetReservationResponse response = new GetReservationResponse();
        Reservation reservation = reservationService.findById(request.getId());
        response.setReservation(reservation);
        return response;
    }
}