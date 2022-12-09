package itmo.soa.controllers;

import itmo.soa.dto.DragonDto;
import itmo.soa.exceptions.DragonNotFoundException;
import itmo.soa.exceptions.IllegalIdException;
//import itmo.soa.services.*;
//import ru.itmo.services.*;
import ru.itmo.soa.*;
import ru.itmo.soa.services.DragonsServiceInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
 http://localhost:8080/dragon-ejb-1.0-SNAPSHOT/api/res/lol
 http://localhost:8080 - понятно
 /dragon-ejb-1.0-SNAPSHOT - это наша программа
 /api - это написано в WebServiceApp - наш вход для использования JAX-RS
 /res - общий path для всех методов в данном ресурсе (контроллере)
 /lol - понятно
 */

@Stateless
@Path(value = "/res")
public class TestResource {

    @EJB(name="ejb:/dragon-ejb/DragonsService!ru.itmo.soa.services.DragonsServiceInterface")
    DragonsServiceInterface dragonsService;

    @GET
    @Path("/lol")
    @Produces(value = MediaType.TEXT_PLAIN)
    public String some() {

        return "LOL";
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotification(@PathParam("id") String id) {

        ru.itmo.soa.dto.DragonDto dragonById = new ru.itmo.soa.dto.DragonDto();
        try {
            dragonById = dragonsService.getDragonById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.ok()
                .entity(dragonById)
                .build();
    }

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }
}
