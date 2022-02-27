package Dao;

import Entities.TaxiDriver;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

public List<TaxiDriver> readTaxiDriver(Boolean activo) {
    conection();
    TypedQuery<TaxiDriver> consulta=em.createQuery("Select l from TaxiDriver l where l.active =?1", TaxiDriver.class);
    consulta.setParameter(1, activo);
    List<TaxiDriver> taxiDrivers = consulta.getResultList();
    disconection();
    return taxiDrivers;
}


    public void updateTaxiDriverIsEnable(String dni) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query consulta = em.createQuery("Update TaxiDriver l Set l.active = true WHERE l.dni=?1");
        consulta.setParameter(1, dni);
        consulta.executeUpdate();
        tx.commit();
        disconection();
    }

    public void updateTaxiDriverIsNotEnable(String dni) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query consulta = em.createQuery("Update TaxiDriver l Set l.active = false WHERE l.dni=?1");
        consulta.setParameter(1, dni);
        consulta.executeUpdate();
        tx.commit();
        disconection();
    }

}
