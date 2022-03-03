package Dao;

import Entities.Journey;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalTime;
import java.util.List;

import static Connection.Connection.*;

public class JourneyDao {
    public void create(Journey journey) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(journey);
        tx.commit();
        disconection();
    }

    public Journey findById(Long id) {
        conection();
        Journey journey = em.find(Journey.class, id);
        disconection();
        return journey;
    }

    public void updateJourney(Journey journey) {
        Journey journeyDB = findById(journey.getId());
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        if (journeyDB.getId().equals(journey.getId())) {
            journeyDB.setEndHour(LocalTime.now().toString());
          //  Query consulta = em.createQuery("Update Journey l Set l.endHour = ?1 WHERE l.id =?2");
          //  consulta.setParameter(1, journeyDB.getEndHour());
           // consulta.setParameter(2, journeyDB.getId());
           // consulta.executeUpdate();
        }
        tx.commit();
        disconection();
    }

    public List<Journey> read() {
        conection();
        TypedQuery<Journey> consulta = em.createQuery("Select l from Journey l ", Journey.class);
        List<Journey> journeis = consulta.getResultList();
        disconection();
        return journeis;
    }

    public List<Journey> readNull() {
        conection();
        TypedQuery<Journey> consulta = em.createQuery("Select l from Journey l where l.endHour = null ", Journey.class);
        List<Journey> journeis = consulta.getResultList();
        disconection();
        return journeis;
    }

}
