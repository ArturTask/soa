package itmo.soa.controllers;

import itmo.soa.dao.DragonCavesDao;
import itmo.soa.dao.DragonsDao;
import itmo.soa.dto.DragonCaveDto;
import itmo.soa.dto.DragonDto;
import itmo.soa.entity.Coordinates;
import itmo.soa.entity.DragonCave;
import itmo.soa.entity.DragonDbo;
import itmo.soa.enums.Color;
import itmo.soa.enums.DragonCharacter;
import itmo.soa.enums.DragonType;
import itmo.soa.services.DragonsService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/helloWorld")
@Stateless
public class MyHttpServlet extends HttpServlet {

    @EJB
    private DragonsDao dragonsDao;

//    @EJB
//    private DragonCavesDao cavesDao;

    @EJB
    private DragonsService dragonsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DragonCave dc = new DragonCave( 122121);
//        cavesDao.save(dc);
        DragonDbo dragonDbo = new DragonDbo("nanan", 1L, 1L, "19.04.2002", 12L, Color.BLACK, DragonType.AIR, DragonCharacter.CHAOTIC, dc);
//        dragonsDao.save(dragonDbo);
        resp.getWriter().write("helloooooo");
        try {
            DragonDto dragonDto = dragonsService.addNewDragon(new DragonDto("nanan", new Coordinates(1L, 1L), "19.04.2002", 12L, Color.BLACK, DragonType.AIR, DragonCharacter.CHAOTIC, dc));
            System.out.println("lala");
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
//AS_JAVA="/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home"