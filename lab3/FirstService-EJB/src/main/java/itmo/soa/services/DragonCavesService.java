package itmo.soa.services;

import itmo.soa.dao.DragonCavesDao;
import itmo.soa.dto.DragonCaveDto;
import itmo.soa.entity.DragonCave;

import javax.ejb.EJB;
//import javax.ejb.Remote;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.LinkedList;
import java.util.List;

@Stateless
//@Remote(DragonCavesServiceInterface.class)
public class DragonCavesService {

    @EJB
    private DragonCavesDao cavesDao;

    public List<DragonCaveDto> getCaves(){
        List<DragonCave> allCaves = cavesDao.findAll();
        List<DragonCaveDto> dragonCaves = new LinkedList<>();
        for (DragonCave dragonCave : allCaves) {
            dragonCaves.add(new DragonCaveDto(dragonCave));
        }
        return dragonCaves;
    }
}
