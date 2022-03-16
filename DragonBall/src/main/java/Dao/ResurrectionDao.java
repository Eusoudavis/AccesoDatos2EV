package Dao;

import Entities.Dragon;
import Entities.Resurrection;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.util.List;

import static Connection.Connection.*;

public class ResurrectionDao {
    public void create(Resurrection resurrection) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(resurrection);
        tx.commit();
        disconection();
    }

    public List<Resurrection> read() {
        conection();
        TypedQuery<Resurrection> consulta = em.createQuery("Select l from Resurrection l ", Resurrection.class);
        List<Resurrection> resurrectionList = consulta.getResultList();
        disconection();
        return resurrectionList;
    }

    public void delete(Resurrection resurrection) {
        conection();
        Resurrection  resurrection1 = em.find(Resurrection.class, resurrection.getId());
        if (resurrection1 != null ){
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(resurrection1);
            tx.commit();
        }else {
            System.out.println("Esta equipa non existe");
        }
        disconection();
    }
}
