package Dao;

import Entities.TaxiDriver;

import javax.persistence.EntityTransaction;

import static Connection.Connection.*;

public class TaxiDriverDao {
    public void create(TaxiDriver taxiDriver) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(taxiDriver);
        tx.commit();
        disconection();
    }

    public TaxiDriver findById(String dni) {
        conection();
        TaxiDriver taxiDriver = em.find(TaxiDriver.class, dni);
        disconection();
        return taxiDriver;
    }

    public void updateTaxiDriver(TaxiDriver taxiDriver) {
        TaxiDriver taxiDriverDB = findById(taxiDriver.getDni());
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        if (!taxiDriverDB.equals(taxiDriver)) {
            taxiDriverDB.setActive(taxiDriver.getActive());
           // taxiDriverDB.setTaxis(taxiDriver.getTaxis());
        }
        tx.commit();
        disconection();
    }

}
