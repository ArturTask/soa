package itmo.soa.services;

import itmo.soa.services.jaxws.*;
import itmo.soa.services.jaxws.KillersService;

import java.net.MalformedURLException;
import java.net.URL;

public class TestService {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8082/ws/killers?wsdl");
        KillersServiceService service = new KillersServiceService(url);
        KillersService proxy = service.getKillersServicePort();


        System.out.println(proxy.getCaveId());
        try {
            proxy.moveToCave("1");
        } catch (CertificateException_Exception e) {
            System.out.println("0");
        } catch (DragonsServiceException_Exception e) {
            System.out.println("1");
        } catch (IOException_Exception e) {
            System.out.println("2");
        } catch (KeyManagementException_Exception e) {
            System.out.println("3");
        } catch (KeyStoreException_Exception e) {
            System.out.println("4");
        } catch (NoSuchAlgorithmException_Exception e) {
            System.out.println("5");
        } catch (UnrecoverableKeyException_Exception e) {
            System.out.println("6");
        }
        catch (Exception e){
            System.out.println("ddssdsd");
        }

        System.out.println(proxy.getCaveId());
    }
}
