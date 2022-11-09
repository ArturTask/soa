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
    private EntityManager entityManager;

    public List<DragonDbo> findAll() {
        return entityManager.createQuery("select d from DragonDbo d", DragonDbo.class).getResultList();
    }

    public void save(DragonDbo dragonDbo) {

        entityManager.persist(dragonDbo);
        entityManager.flush(); // may cause trouble
    }

    public Optional<DragonDbo> findById(Long id) {
        List<DragonDbo> dragonDbos = entityManager.createQuery("select d from DragonDbo d where d.id = " + id, DragonDbo.class).getResultList();

        if (dragonDbos.isEmpty()) {
            return Optional.empty();
        }
        else {
            return Optional.of(dragonDbos.get(0));
        }
    }

    public void deleteById(long id) {
        entityManager.createQuery("delete from DragonDbo d where d.id = " + id);
    }
}
