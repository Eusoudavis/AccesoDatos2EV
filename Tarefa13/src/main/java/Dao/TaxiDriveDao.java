package Dao;

import Entities.Taxi;
import Entities.TaxiDriver;

import javax.persistence.EntityTransaction;

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
}
