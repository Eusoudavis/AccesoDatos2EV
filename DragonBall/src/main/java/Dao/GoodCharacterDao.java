package Dao;

import Entities.Dragon;
import Entities.GoodCharacter;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import static Connection.Connection.*;

public class GoodCharacterDao {
    public void create(GoodCharacter goodCharacter) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(goodCharacter);
        tx.commit();
        disconection();
    }

    public GoodCharacter findById(Integer id) {
        conection();
        GoodCharacter goodCharacter = em.find(GoodCharacter.class, id);
        disconection();
        return goodCharacter;
    }

    public GoodCharacter findByName(String name){
        conection();
        TypedQuery<GoodCharacter> consulta = em.createQuery("Select l from GoodCharacter l where l.name = ?1 ", GoodCharacter.class);
        consulta.setParameter(1, name);
        GoodCharacter goodCharacter = consulta.getSingleResult();
        disconection();
        return goodCharacter;
    }

    public void update(GoodCharacter goodCharacter) {
        // Ordenador ordenadorDB = findById(ordenador.getIdPC());
        //GoodCharacter goodCharacterDB = findById(goodCharacter.getId());
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        GoodCharacter goodCharacterDB = em.find(GoodCharacter.class, goodCharacter.getId());
        if (goodCharacter.getAlive()!=null){
            goodCharacterDB.setAlive(goodCharacter.getAlive());
        }else if (goodCharacter.getKi()==(null)){
            goodCharacterDB.setKi(goodCharacter.getKi());
        }
        tx.commit();
        disconection();
    }

    public void delete(GoodCharacter goodCharacter) {
        conection();
        GoodCharacter  gcDelete = em.find(GoodCharacter.class, goodCharacter.getId());
        if (gcDelete != null ){
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(gcDelete);
            tx.commit();
        }else {
            System.out.println("Esta equipa non existe");
        }
        disconection();
    }
}
