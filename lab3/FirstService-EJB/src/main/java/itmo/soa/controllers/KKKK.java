package itmo.soa.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(value = "/hello")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class KKKK {

    @GET
    @Path("find_by_cave_depth")
    public String get(){

        return null; //TODO replace this stub to something useful
    }

}
