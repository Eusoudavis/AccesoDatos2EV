package Dao;

import Entities.Taxi;
import Entities.TaxiDriver;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

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
    public void updateTaxiDriver(String dni) {
        TaxiDriver taxiDriver = findById(dni);
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<Taxi> taxis = new ArrayList<>();
        Taxi taxi = new Taxi();
        taxi.setCarRegistrationNumber("1234fff");
        taxis.add(taxi);
        taxiDriver.setTaxis(taxis);
        tx.commit();
        disconection();
    }
}
