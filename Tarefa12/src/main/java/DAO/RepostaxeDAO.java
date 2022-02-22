package DAO;

import Entity.Enchido;
import Entity.Repostaxe;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.util.List;

import static Connection.Connection.*;

public class RepostaxeDAO {
    public void create(Repostaxe repostaxe) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(repostaxe);
        tx.commit();
        disconection();
    }

    public List<Repostaxe> read() {
        conection();
        TypedQuery<Repostaxe> consulta=em.createQuery("Select l from Repostaxe l", Repostaxe.class);
        List<Repostaxe> repostaxes = consulta.getResultList();
        disconection();
        return repostaxes;
    }
}
