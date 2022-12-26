package itmo.soa.services;

import itmo.soa.exceptions.DragonsServiceException;
import org.springframework.http.HttpMethod;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

@WebService
public interface RequestInterface {
    
    @WebMethod
    public <T> T sendRequest(String url, HttpMethod method, Class<T> dtoClass)throws IOException, DragonsServiceException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException;
}
