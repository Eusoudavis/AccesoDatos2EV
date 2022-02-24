package Dao;

import Entities.Taxi;

import javax.persistence.EntityTransaction;

import static Connection.Connection.*;

public class TaxiDao {
    public void create(Taxi taxi) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(taxi);
        tx.commit();
        disconection();
    }
}
