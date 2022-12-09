package ru.itmo.soa.dao;

import ru.itmo.soa.entity.DragonCave;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;
import java.util.Optional;


@Stateless
public class DragonCavesDao {

    @PersistenceContext(unitName = "myPersistenceUnit")
    private EntityManager entityManager;

    public void save(DragonCave cave) {
        entityManager.persist(cave);
    }


    public Optional<DragonCave> findById(long id) {

        List<DragonCave> caves = entityManager.createQuery("select d from DragonCave d where d.id = " + id, DragonCave.class).getResultList();
        if (caves.isEmpty()) {
            return Optional.empty();
        }
        else {
            return Optional.of(caves.get(0));
        }
    }

    public List<DragonCave> findAll() {
        return entityManager.createQuery("select d from DragonCave d", DragonCave.class).getResultList();
    }
}


//public void save(DragonCave cave) {
//
//        EntityManagerFactory entityManagerFactory = null;
//        EntityManager entityManager = null;
//        try {
//            entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
//            entityManager = entityManagerFactory.createEntityManager();
//            EntityTransaction transaction = entityManager.getTransaction();
//            transaction.begin();
//            // operation:
//            entityManager.persist(cave);
//            //
//            transaction.commit();
//        } catch (Exception ignore) {
//
//        } finally {
//            if (entityManagerFactory != null) {
//                entityManagerFactory.close();
//            }
//            if (entityManager != null) {
//                entityManager.close();
//            }
//        }
//    }
