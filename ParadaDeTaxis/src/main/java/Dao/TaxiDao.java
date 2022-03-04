package Dao;

import Entities.Taxi;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public void updateTaxiEnable(String matricula) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query consulta = em.createQuery("Update Taxi l Set l.available = true WHERE l.carRegistrationNumber=?1");
        consulta.setParameter(1, matricula);
        consulta.executeUpdate();
        tx.commit();
        disconection();
    }

    public List<Taxi> readTaxi(Boolean activo) {
        conection();
        TypedQuery<Taxi> consulta = em.createQuery("Select l from Taxi l where l.available=?1", Taxi.class);
        consulta.setParameter(1, activo);
        List<Taxi> taxis = consulta.getResultList();
        disconection();
        return taxis;
    }
}
