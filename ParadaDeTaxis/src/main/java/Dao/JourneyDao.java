package Dao;

import Entities.Journey;

import javax.persistence.EntityTransaction;

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
        if (journeyDB.equals(journey)) {
            journeyDB.setEndHour(journey.getEndHour());
        }
        tx.commit();
        disconection();
    }


}
