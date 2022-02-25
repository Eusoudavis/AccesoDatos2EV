package Dao;

import Entities.Taxi;
import Entities.TaxiDriver;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import static Connection.Connection.*;

public class TaxiDriveDao {
    public void create(TaxiDriver taxiDriver) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(taxiDriver);
        tx.commit();
        disconection();
    }

    public void updateTaxiDriver(String dni) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query consulta = em.createQuery("Update TaxiDriver t Set t.active = true WHERE l.dni=?1");
        consulta.setParameter(1, dni);
        consulta.executeUpdate();
        tx.commit();
        disconection();
    }
}
