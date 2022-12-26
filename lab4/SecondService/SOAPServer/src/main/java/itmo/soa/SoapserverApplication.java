package itmo.soa;

import itmo.soa.services.ws.KillersService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.ws.Endpoint;

@SpringBootApplication
public class SoapserverApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SoapserverApplication.class, args);
        Endpoint.publish("http://localhost:8082/ws/killers", new KillersService());
        System.out.println("DONE");
//        SpringApplication.run(SoapserverApplication.class, args);
    }

}
