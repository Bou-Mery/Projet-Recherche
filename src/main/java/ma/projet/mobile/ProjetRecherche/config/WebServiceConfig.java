package ma.projet.mobile.ProjetRecherche.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public DefaultWsdl11Definition chambreWsdl11Definition(XsdSchema chambreSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ChambrePort");
        wsdl11Definition.setLocationUri("/ws/chambres");
        wsdl11Definition.setTargetNamespace("http://projet.mobile.ma/soap");
        wsdl11Definition.setSchema(chambreSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema chambreSchema() {
        return new SimpleXsdSchema(new ClassPathResource("chambre.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition clientWsdl11Definition(XsdSchema clientSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ClientPort");
        wsdl11Definition.setLocationUri("/ws/clients");
        wsdl11Definition.setTargetNamespace("http://projet.mobile.ma/soap");
        wsdl11Definition.setSchema(clientSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema clientSchema() {
        return new SimpleXsdSchema(new ClassPathResource("client.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition utilisateurWsdl11Definition(XsdSchema utilisateurSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("UtilisateurPort");
        wsdl11Definition.setLocationUri("/ws/utilisateurs");
        wsdl11Definition.setTargetNamespace("http://projet.mobile.ma/soap");
        wsdl11Definition.setSchema(utilisateurSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema utilisateurSchema() {
        return new SimpleXsdSchema(new ClassPathResource("utilisateur.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition reservationWsdl11Definition(XsdSchema reservationSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ReservationPort");
        wsdl11Definition.setLocationUri("/ws/reservations");
        wsdl11Definition.setTargetNamespace("http://projet.mobile.ma/soap");
        wsdl11Definition.setSchema(reservationSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema reservationSchema() {
        return new SimpleXsdSchema(new ClassPathResource("reservation.xsd"));
    }
}