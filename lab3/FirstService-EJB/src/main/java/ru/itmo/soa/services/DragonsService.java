package ru.itmo.soa.services;

import ru.itmo.soa.dao.DragonCavesDao;
import ru.itmo.soa.dao.DragonsDao;
import ru.itmo.soa.dto.AgeDto;
import ru.itmo.soa.dto.DragonDto;
import ru.itmo.soa.entity.Dragon;
import ru.itmo.soa.entity.DragonCave;
import ru.itmo.soa.entity.DragonDbo;
import ru.itmo.soa.exceptions.CaveNotFoundException;
import ru.itmo.soa.exceptions.DragonNotFoundException;
import ru.itmo.soa.exceptions.IllegalAgeException;
import ru.itmo.soa.exceptions.IllegalIdException;

import javax.ejb.EJB;
//import javax.ejb.Remote;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Stateless
@Remote(DragonsServiceInterface.class)
public class DragonsService implements DragonsServiceInterface{

    @EJB
    private DragonsDao dragonsDao;

    @EJB
    private DragonCavesDao caveDao;

//    @PersistenceContext(unitName = "myPersistenceUnit")
//    private EntityManager entityManager;

    @Override
    public List<DragonDto> getAllDragons(){
        Iterable<DragonDbo> all = dragonsDao.findAll();
        List<DragonDto> dragonLinkedList = new LinkedList<>();
        for (DragonDbo dragonDbo : all) {
            dragonLinkedList.add(new DragonDto(dragonDbo));
        }
        return dragonLinkedList;
    }

    @Override
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
        dragonDto.setId(dragonDbo.getId());
        dragonDto.setCreationDate(dragonDbo.getCreationDate());
        return dragonDto;
    }

    @Override
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

    @Override
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

    @Override
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
    @Override
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

    @Override
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

    @Override
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
