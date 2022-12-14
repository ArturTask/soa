package ru.itmo.soa.dto;

import ru.itmo.soa.entity.Coordinates;
import ru.itmo.soa.entity.Dragon;
import ru.itmo.soa.entity.DragonCave;
import ru.itmo.soa.entity.DragonDbo;
import ru.itmo.soa.enums.Color;
import ru.itmo.soa.enums.DragonCharacter;
import ru.itmo.soa.enums.DragonType;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Data
@NoArgsConstructor
public class DragonDto implements Serializable {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private Long id;
    private String name;
    private Coordinates coordinates;
    private String creationDate;
    private Long age;
    private Color color;
    private DragonType type;
    private DragonCharacter character;
    private DragonCave cave;

    public DragonDto(Long id, String name, Coordinates coordinates, String creationDate, long age, String color, String type, String character, DragonCave cave) {

        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        setCreationDate(creationDate);
        this.age = age;
        this.color = Color.valueOf(color);
        this.type = DragonType.valueOf(type);
        this.character = DragonCharacter.valueOf(character);
        this.cave = cave;
    }

    public DragonDto(String name, Coordinates coordinates, String creationDate, long age, Color color, DragonType type, DragonCharacter character, DragonCave cave) {
        this.name = name;
        this.coordinates = coordinates;
        setCreationDate(creationDate);
        this.age = age;
        this.color = color;
        this.type = type;
        this.character = character;
        this.cave = cave;
    }

    public DragonDto(Dragon dragon) {
        this.id = dragon.getId();
        this.name = dragon.getName();
        this.coordinates = dragon.getCoordinates();
        setCreationDate(dragon.getCreationDate());
        this.age = dragon.getAge();
        this.color = dragon.getColor();
        this.type = dragon.getType();
        this.character = dragon.getCharacter();
        this.cave = dragon.getCave();
    }

    public DragonDto(DragonDbo dragonDbo) {
        this.id = dragonDbo.getId();
        this.name = dragonDbo.getName();
        this.coordinates = new Coordinates(dragonDbo.getX(), dragonDbo.getY());
        this.creationDate = dragonDbo.getCreationDate();
        this.age = dragonDbo.getAge();
        this.color = dragonDbo.getColor();
        this.type = dragonDbo.getType();
        this.character = dragonDbo.getCharacter();
        this.cave = dragonDbo.getCave();
    }

//    public String getCreationDate() {
//        return FORMAT.format(this.creationDate);
//    }
//
//    public void setCreationDate(String creationDateUsingFormat) throws DateTimeParseException {
//        LocalDateTime ldt = LocalDate.parse(creationDateUsingFormat, FORMAT).atStartOfDay();
//        this.creationDate = ldt.atZone(ZoneId.of("Europe/Moscow"));
//    }

    public boolean setAge(long age) {
        if (age > 0) {
            this.age = age;
            return true;
        }
        return false;
    }

    public boolean setName(String name) {
        if (!name.equals("")) {
            this.name = name;
            return true;
        }
        return false;
    }

    private boolean checkCreationDate(String creationDateUsingFormat) {
        try {
            LocalDateTime ldt = LocalDate.parse(creationDateUsingFormat, FORMAT).atStartOfDay();
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean checkInputValues(Long id, String name, Coordinates coordinates, String creationDate, long age, Color color, DragonType type, DragonCharacter character, DragonCave cave) {
        if (id <= 0 || name == null || name.equals("") || age <= 0) {
            return false;
        }
        return checkCreationDate(creationDate);
    }

}


