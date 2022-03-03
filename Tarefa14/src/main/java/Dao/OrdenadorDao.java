package Dao;

import Entities.Alumno;
import Entities.Ordenador;

import javax.persistence.EntityTransaction;

import static Connection.Connection.*;

public class OrdenadorDao {
    public void create(Ordenador ordenador) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(ordenador);
        tx.commit();
        disconection();
    }

    public Ordenador findById(String id) {
        conection();
        Ordenador ordenador = em.find(Ordenador.class, id);
        disconection();
        return ordenador;
    }
}
