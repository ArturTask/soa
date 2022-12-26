package itmo.soa.services;

import com.google.gson.Gson;
import itmo.soa.dto.ErrorDto;
import itmo.soa.exceptions.DragonsServiceException;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

//@Service
public class RequestService{

    public <T> T sendRequest(String url, HttpMethod method, Class<T> dtoClass) throws IOException, DragonsServiceException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException { // returns any dto (t extends object)

        HttpUriRequest req = null;

        switch (method){
            case GET:{req = new HttpGet(url); break;}
            case POST:{req = new HttpPost(url); break;}
            case PUT:{req = new HttpPut(url); break;}
            case DELETE:{req = new HttpDelete(url); break;}
            default:{break;}
        }

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) { // here include our prepared ssl
            try (CloseableHttpResponse response = httpClient.execute(req)) {
                int statusCode = response.getStatusLine().getStatusCode();
                System.out.println(statusCode);
                String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                if(statusCode!=200){
                    String myErrMessage = "";
                    try {
                        ErrorDto errorDto = getEntityFromJson(responseBody, ErrorDto.class);
                        myErrMessage = errorDto.getError();
                    }
                    catch (Exception ignored){
                    }

                    throw new DragonsServiceException("status code: " + statusCode + " message: " + myErrMessage);
                }
//                System.out.println("Response body: " + responseBody);
                return getEntityFromJson(responseBody, dtoClass);
            }
        }

    }


    private <T> T getEntityFromJson(String jsonEntity, Class<T> entityClass){
        return new Gson().fromJson(jsonEntity, entityClass);
    }


}
