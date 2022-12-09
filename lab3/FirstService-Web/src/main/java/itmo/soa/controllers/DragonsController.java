package itmo.soa.controllers;

import org.springframework.http.HttpStatus;
import ru.itmo.soa.dto.AllDragonsDto;
import ru.itmo.soa.dto.DefaultDto;
import ru.itmo.soa.dto.DragonDto;
import ru.itmo.soa.exceptions.CaveNotFoundException;
import ru.itmo.soa.exceptions.DragonNotFoundException;
import ru.itmo.soa.exceptions.IllegalAgeException;
import ru.itmo.soa.exceptions.IllegalIdException;
import ru.itmo.soa.services.DragonsService;
import ru.itmo.soa.services.DragonsServiceInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

@Stateless
@Path(value = "/dragons")
public class DragonsController {

    @EJB(name="ejb:/dragon-ejb/DragonsService!ru.itmo.soa.services.DragonsServiceInterface")
    DragonsServiceInterface dragonsService;

    @Produces(value = MediaType.APPLICATION_JSON)
    @GET
    @Path("")
    public Response getAllDragons(){
        return Response.ok(new AllDragonsDto(dragonsService.getAllDragons())).build();
    }

    @POST
    @Path("")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response addNewDragon(DragonDto dragonDto) throws InstantiationException {
        return Response.ok(dragonsService.addNewDragon(dragonDto)).build();
    }


    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @PUT
    @Path("")
    public Response updateDragon(DragonDto dragonDto) throws InstantiationException, DragonNotFoundException, CaveNotFoundException {
        return Response.ok(dragonsService.updateDragon(dragonDto)).build();

    }

    @Consumes(value = MediaType.TEXT_PLAIN)
    @Produces(value = MediaType.APPLICATION_JSON)
    @GET
    @Path(value = "/{id}")
    public Response getDragonById(@PathParam(value = "id") String id) throws IllegalIdException, DragonNotFoundException {
        return Response.ok(dragonsService.getDragonById(id)).build();
    }

    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.TEXT_PLAIN)
    @DELETE
    @Path(value = "/{id}") //@DeleteMapping(value = "/{id:[\\d]+}") - only allows delete mapping with numeric id!! => /dragons/f - another controller
    public Response deleteDragonById(@PathParam(value = "id") String id) throws IllegalIdException, DragonNotFoundException {
        dragonsService.deleteDragonById(id);
        return Response.ok(new DefaultDto(HttpStatus.OK.value(), "Successful Operation")).build();
    }

    /*business logic*/

    @Produces(value = MediaType.TEXT_PLAIN)
    @POST
    @Path(value = "/age/average")
    public Response getAverageAge(){
        return Response.ok(dragonsService.getAverageAge()).build();
    }

    @Consumes(value = MediaType.TEXT_PLAIN)
    @Produces(value = MediaType.APPLICATION_JSON)
    @POST
    @Path(value = "/age/less/{age}")
    public Response getDragonsAgeLessThan(@PathParam(value = "age") String age) throws IllegalAgeException {
        return Response.ok(new AllDragonsDto(dragonsService.getDragonsAgeLessThan(age))).build();
    }

    @Consumes(value = MediaType.TEXT_PLAIN)
    @Produces(value = MediaType.APPLICATION_JSON)
    @POST
    @Path(value = "/name/starts/{namePrefix}")
    public Response getDragonsStartsWithName(@PathParam(value = "namePrefix") String namePrefix){
        return Response.ok(new AllDragonsDto(dragonsService.getDragonsStartsWithName(namePrefix))).build();
    }



}
