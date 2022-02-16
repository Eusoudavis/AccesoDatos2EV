package Dao;

import Connection.Connection;
import Entities.Manual;
import Entities.Revista;
import Interfaces.Interfaz;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

import static Connection.Connection.*;


public class ManualDao implements Interfaz<Manual, Long> {
    @Override
    public void create(Manual manual) {
        Connection.conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(manual);
        tx.commit();
        Connection.disconection();
    }

    @Override
    public Manual findById(Long s) {
        conection();
        Manual manual = em.find(Manual.class, s);
        disconection();
        return manual;
    }

    @Override
    public List<Manual> read() {
        conection();
        TypedQuery<Manual> consulta=em.createQuery("Select l from Manual l", Manual.class);
        List<Manual> manuais = consulta.getResultList();
        disconection();
        return manuais;     }

    @Override
    public void delete(Manual manual) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        manual = em.getReference(Manual.class, manual.getIsbn());
        em.remove(manual);
        tx.commit();
        disconection();
    }
}
