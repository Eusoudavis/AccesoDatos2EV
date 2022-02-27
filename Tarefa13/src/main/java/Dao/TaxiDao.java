package Dao;

import Entities.Taxi;
import Entities.TaxiDriver;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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

    public Taxi findById(String matricula) {
        conection();
        Taxi taxi = em.find(Taxi.class, matricula);
        disconection();
        return taxi;
    }

    public void updateTaxiNoEnable(String matricula) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query consulta = em.createQuery("Update Taxi l Set l.available = false WHERE l.carRegistrationNumber=?1");
        consulta.setParameter(1, matricula);
        consulta.executeUpdate();
        tx.commit();
        disconection();
    }
}
