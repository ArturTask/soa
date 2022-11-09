package itmo.soa.services;

import itmo.soa.dao.DragonCavesDao;
import itmo.soa.dao.DragonsDao;
import itmo.soa.dto.AgeDto;
import itmo.soa.dto.DragonDto;
import itmo.soa.entity.Dragon;
import itmo.soa.entity.DragonCave;
import itmo.soa.entity.DragonDbo;
import itmo.soa.exceptions.CaveNotFoundException;
import itmo.soa.exceptions.DragonNotFoundException;
import itmo.soa.exceptions.IllegalAgeException;
import itmo.soa.exceptions.IllegalIdException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Stateless
public class DragonsService {


    @EJB
    private DragonsDao dragonsDao;

    @EJB
    private DragonCavesDao caveDao;

//    @PersistenceContext(unitName = "myPersistenceUnit")
//    private EntityManager entityManager;

    public List<DragonDto> getAllDragons(){
        Iterable<DragonDbo> all = dragonsDao.findAll();
        List<DragonDto> dragonLinkedList = new LinkedList<>();
        for (DragonDbo dragonDbo : all) {
            dragonLinkedList.add(new DragonDto(dragonDbo));
        }
        return dragonLinkedList;
    }

    public DragonDto addNewDragon(DragonDto dragonDto) throws InstantiationException {
        if (dragonDto.getId()!=null){
            throw new InstantiationException();
        }
        if (dragonDto.getCave()!=null && dragonDto.getCave().getId()!=0){
            throw new InstantiationException();
        }
        Dragon dragon = new Dragon(dragonDto); // if something is wrong throw new InstantiationException()
        DragonDbo dragonDbo = new DragonDbo(dragon);
        caveDao.save(dragonDbo.getCave());
        dragonsDao.save(dragonDbo);
//        dragonsDao.flush(); todo
        dragonDto.setId(dragonDbo.getId());
        dragonDto.setCreationDate(dragonDbo.getCreationDate());
        return dragonDto;
    }

    public DragonDto updateDragon(DragonDto dragonDto) throws InstantiationException, DragonNotFoundException, CaveNotFoundException {

        Optional<DragonDbo> dragonDbo = dragonsDao.findById(dragonDto.getId());
        if (!dragonDbo.isPresent()){
            throw new DragonNotFoundException();
        }
        Optional<DragonCave> caveDbo = caveDao.findById(dragonDto.getCave().getId());
        if (!caveDbo.isPresent()){
            throw new CaveNotFoundException();
        }
        Dragon dragon = new Dragon(dragonDto);
        dragonsDao.save(dragonDbo.get().update(dragon));
        return dragonDto;
    }

    public DragonDto getDragonById( String id) throws IllegalIdException, DragonNotFoundException {
        try {
            Optional<DragonDbo> dragon = dragonsDao.findById(Long.parseLong(id));
            if (!dragon.isPresent()){
                throw new DragonNotFoundException();
            }
            return new DragonDto(dragon.get());
        }
        catch (NumberFormatException e){
            throw new IllegalIdException("Illegal id", e);
        }
    }

    public void deleteDragonById( String id) throws IllegalIdException, DragonNotFoundException {
        try {
            Optional<DragonDbo> dragon = dragonsDao.findById(Long.parseLong(id));
            if (!dragon.isPresent()){
                throw new DragonNotFoundException();
            }
            dragonsDao.deleteById(Long.parseLong(id));
        }
        catch (NumberFormatException e){
            throw new IllegalIdException("Illegal id", e);
        }
    }

    //    business logic
    public AgeDto getAverageAge(){
        List<DragonDbo> allDragons = dragonsDao.findAll();
        if (allDragons.isEmpty()){
            return new AgeDto((float) 0.0);
        }
        Long summAge = 0L;
        for (DragonDbo dragonDbo : allDragons) {
            summAge += dragonDbo.getAge();
        }
        return new AgeDto((float) (summAge/allDragons.size()));
    }

    public List<DragonDto> getDragonsAgeLessThan(String age) throws IllegalAgeException {
        try {
            long lessThanAge = Long.parseLong(age);

            List<DragonDbo> allDragons = dragonsDao.findAll();
            if (allDragons.isEmpty()) {
                return new LinkedList<>(); // empty list
            }

            List<DragonDto> currentDragons = new LinkedList<>();
            for (DragonDbo dragonDbo : allDragons) {
                if (dragonDbo.getAge() < lessThanAge) {
                    currentDragons.add(new DragonDto(dragonDbo));
                }
            }
            return currentDragons;
        }
        catch (NumberFormatException e){
            throw new IllegalAgeException("Wrong dragon age", e);
        }
    }

    public List<DragonDto> getDragonsStartsWithName(String namePrefix){

        List<DragonDbo> allDragons = dragonsDao.findAll();
        if (allDragons.isEmpty()|| namePrefix==null){
            return new LinkedList<>(); // empty list
        }

        List<DragonDto> currentDragons = new LinkedList<>();
        for (DragonDbo dragonDbo : allDragons) {
            if (dragonDbo.getName().startsWith(namePrefix)){
                currentDragons.add(new DragonDto(dragonDbo));
            }
        }
        return currentDragons;
    }

}
