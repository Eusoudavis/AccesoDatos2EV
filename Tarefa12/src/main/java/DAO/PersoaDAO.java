package DAO;

import Entity.Persoa;
import Entity.Repostaxe;

import javax.persistence.EntityTransaction;

import static Connection.Connection.*;

public class PersoaDAO {
    public void create(Persoa persoa) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(persoa);
        tx.commit();
        disconection();
    }

    public Persoa findById(String dni) {
        conection();
        Persoa persoa = em.find(Persoa.class, dni);
        disconection();
        return persoa;
    }
}
