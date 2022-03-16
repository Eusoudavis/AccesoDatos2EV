package Dao;

import Entities.Dragon;
import Entities.GoodCharacter;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.util.List;

import static Connection.Connection.*;

public class DragonDao {
    public void create(Dragon dragon) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(dragon);
        tx.commit();
        disconection();
    }

    public Dragon findById(Integer id) {
        conection();
        Dragon dragon = em.find(Dragon.class, id);
        disconection();
        return dragon;
    }

    public Dragon findByName(String name){
        conection();
        TypedQuery<Dragon> consulta = em.createQuery("Select l from Dragon l where l.name = ?1 ", Dragon.class);
        consulta.setParameter(1, name);
        Dragon dragon = consulta.getSingleResult();
        disconection();
        return dragon;
    }
}
