package itmo.soa.dao;

import itmo.soa.entity.DragonDbo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class DragonsDao {

    @PersistenceContext(unitName = "myPersistenceUnit")
    EntityManager entityManager;

//    public void saveDragon(DragonDbo dragon){
//        entityManager.persist(dragon);
//    }

    public List<DragonDbo> findAll() {
        return null;
    }

    public void save(DragonDbo dragonDbo) {
        entityManager.persist(dragonDbo);
    }

    public Optional<DragonDbo> findById(Long id) {
        Optional<DragonDbo> dragonDbo = Optional.of(new DragonDbo());
        return Optional.empty();
    }

    public void deleteById(long parseLong) {

    }
}
