package itmo.soa.resources;

import itmo.soa.dao.DragonCavesDao;
import itmo.soa.dao.DragonsDao;
import itmo.soa.dto.DragonCaveDto;
import itmo.soa.entity.DragonCave;
import itmo.soa.entity.DragonDbo;
import itmo.soa.enums.Color;
import itmo.soa.enums.DragonCharacter;
import itmo.soa.enums.DragonType;

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

    @EJB
    private DragonCavesDao cavesDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        DragonCave dc = new DragonCave( 122121);
        cavesDao.save(dc);
        dragonsDao.save(new DragonDbo("nanan", 1L, 1L, "19.04.2002", 12L, Color.BLACK, DragonType.AIR, DragonCharacter.CHAOTIC, dc));
        resp.getWriter().write("helloooooo");


    }
}
//AS_JAVA="/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home"