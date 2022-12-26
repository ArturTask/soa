package itmo.soa.services.ws;

import itmo.soa.dto.DefaultDto;
import itmo.soa.exceptions.DragonsServiceException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

@WebService
public interface KillersInterface {

    @WebMethod
    public String getCaveId();

    @WebMethod
    public DefaultDto killDragon(String id)throws IOException, DragonsServiceException, UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException;

    @WebMethod
    public DefaultDto moveToCave(String moveCaveId) throws IOException, DragonsServiceException, UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException;
}
