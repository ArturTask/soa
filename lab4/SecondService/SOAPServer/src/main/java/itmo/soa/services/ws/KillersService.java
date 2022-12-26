package itmo.soa.services.ws;

import itmo.soa.dto.*;
import itmo.soa.exceptions.DragonsServiceException;
import itmo.soa.services.RequestService;
import itmo.soa.services.UrlService;
import org.springframework.http.HttpStatus;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.List;

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;

//@Service
@WebService
public class KillersService implements KillersInterface{

    private static Long currentCaveId = 0L;

//    @Autowired
    private final RequestService requestService = new RequestService ();

    @WebMethod
    public String getCaveId(){
        return String.valueOf(currentCaveId);
    }

    @WebMethod
    public DefaultDto killDragon(String id) throws IOException, DragonsServiceException, UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        DragonDto dragonDto = requestService.sendRequest(UrlService.getFirstServiceUrlDragons() + id, GET, DragonDto.class);
        if (currentCaveId == null){
            return new DefaultDto(HttpStatus.OK.value(), "You are NOT IN Any CAVE ");
        }
        if (currentCaveId!=dragonDto.getCave().getId()){
            return new DefaultDto(HttpStatus.OK.value(), "Dragon is in another cave: " + dragonDto.getCave().getId());
        }
        requestService.sendRequest(UrlService.getFirstServiceUrlDragons() + id, DELETE, DragonDto.class);
        return new DefaultDto(HttpStatus.OK.value(), "Dragon " + dragonDto.getName() + "(id: " + id + ")" +  " is killed");
    }

    @WebMethod
    public DefaultDto moveToCave(String moveCaveId) throws IOException, DragonsServiceException, UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        try{
            Long.parseLong(moveCaveId);
        }
        catch (NumberFormatException e){
            return new DefaultDto(HttpStatus.OK.value(), "Id is not valid");
        }
        AllDragonCavesDto allDragonCavesDto = requestService.sendRequest(UrlService.getFirstServiceUrlCaves(), GET, AllDragonCavesDto.class);
        List<DragonCaveDto> caves = allDragonCavesDto.getCaves();
        for (DragonCaveDto dragonCaveDto : caves) {
            if (dragonCaveDto.getId()== Long.parseLong(moveCaveId)){
                currentCaveId = Long.parseLong(moveCaveId);
                return new DefaultDto(HttpStatus.OK.value(), "You are now in cave with id " + moveCaveId);
            }
        }
        return new DefaultDto(HttpStatus.OK.value(), "Cave is not present");
    }



}
