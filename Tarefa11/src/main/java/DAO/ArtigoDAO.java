package DAO;

import Entity.Artigos;
import Entity.Xornalista;

import javax.persistence.EntityTransaction;

import static Connection.Connection.*;

public class ArtigoDAO {
    public void create(Artigos artigos) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(artigos);
        tx.commit();
        disconection();
    }
}
