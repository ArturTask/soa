package ru.itmo.soa.services;

import ru.itmo.soa.dto.AgeDto;
import ru.itmo.soa.dto.DragonDto;
import ru.itmo.soa.exceptions.CaveNotFoundException;
import ru.itmo.soa.exceptions.DragonNotFoundException;
import ru.itmo.soa.exceptions.IllegalAgeException;
import ru.itmo.soa.exceptions.IllegalIdException;

import java.util.List;

public interface DragonsServiceInterface {


    public List<DragonDto> getAllDragons();

    public DragonDto addNewDragon(DragonDto dragonDto) throws InstantiationException;

    public DragonDto updateDragon(DragonDto dragonDto) throws InstantiationException, DragonNotFoundException, CaveNotFoundException;

    public DragonDto getDragonById( String id) throws IllegalIdException, DragonNotFoundException;

    public void deleteDragonById( String id) throws IllegalIdException, DragonNotFoundException;

    //    business logic
    public AgeDto getAverageAge();

    public List<DragonDto> getDragonsAgeLessThan(String age) throws IllegalAgeException;

    public List<DragonDto> getDragonsStartsWithName(String namePrefix);

}
