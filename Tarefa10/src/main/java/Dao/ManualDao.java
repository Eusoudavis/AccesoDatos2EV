package Dao;

import Connection.Connection;
import Entities.Manual;
import Interfaces.Interfaz;

import javax.persistence.EntityTransaction;
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
        return null;
    }

    @Override
    public List<Manual> read() {
        return null;
    }

    @Override
    public void update(Manual manual) {

    }

    @Override
    public void delete(Manual manual) {
        conection();
        // Empregado empregadoDelete = em.find(Empregado.class, empregado.getDni());
        //  if (revista != null ){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(manual);
        tx.commit();
        //  }else {
        //      System.out.println("Este empregado non existe");
        //   }
        disconection();
    }
}
