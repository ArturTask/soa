package itmo.soa.controllers;

import itmo.soa.dto.DragonDto;
import itmo.soa.entity.Coordinates;
import itmo.soa.entity.DragonCave;
import itmo.soa.entity.DragonDbo;
import itmo.soa.enums.Color;
import itmo.soa.enums.DragonCharacter;
import itmo.soa.enums.DragonType;
import itmo.soa.exceptions.DragonNotFoundException;
import itmo.soa.exceptions.IllegalIdException;
import itmo.soa.services.DragonsService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
 http://localhost:8080/dragon-ejb-1.0-SNAPSHOT/api/test/lol

 http://localhost:8080 - понятно
 /dragon-ejb-1.0-SNAPSHOT - это наша программа
 /api - это написано в WebServiceApp - наш вход для использования JAX-RS
 /test - общий path для всех методов в данном ресурсе (контроллере)
 /lol - понятно

 */
//@Stateless
@Path(value = "/test")
public class SomeResource {

    @EJB
    DragonsService dragonsService;

    @GET
    @Path("/lol")
    @Produces(value = MediaType.TEXT_PLAIN)
    public String some() {
        DragonCave dc = new DragonCave( 122121);
//        cavesDao.save(dc);
        DragonDbo dragonDbo = new DragonDbo("nanan", 1L, 1L, "19.04.2002", 12L, Color.BLACK, DragonType.AIR, DragonCharacter.CHAOTIC, dc);
//        dragonsDao.save(dragonDbo);

        try {
            DragonDto dragonDto = dragonsService.addNewDragon(new DragonDto("nanan", new Coordinates(1L, 1L), "19.04.2002", 12L, Color.BLACK, DragonType.AIR, DragonCharacter.CHAOTIC, dc));
            System.out.println("lala");
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return "LOL";
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotification(@PathParam("id") String id) {

        DragonDto dragonById = new DragonDto();
        try {
            dragonById = dragonsService.getDragonById(id);
        } catch (IllegalIdException | DragonNotFoundException e) {
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
