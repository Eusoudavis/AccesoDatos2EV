package DAO;

import Entity.Xornalista;

import javax.persistence.EntityTransaction;

import static Connection.Connection.*;

public class XornalistaDAO {
    public void create(Xornalista xornalista) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(xornalista);
        tx.commit();
        disconection();
    }

}
