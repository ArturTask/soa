package itmo.soa.controllers;

import ru.itmo.soa.dto.AllDragonCavesDto;
import ru.itmo.soa.services.DragonCavesService;
import ru.itmo.soa.services.DragonCavesServiceInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path(value = "/caves")
public class DragonCavesController {

    @EJB(name="ejb:/dragon-ejb/DragonCavesService!ru.itmo.soa.services.DragonCavesServiceInterface")
    DragonCavesServiceInterface dragonCavesService;

    @GET
    @Path("")
    @Produces(value = MediaType.TEXT_PLAIN)
    public Response getCaves() {
        return Response.ok(new AllDragonCavesDto(dragonCavesService.getCaves())).build();
    }
}
