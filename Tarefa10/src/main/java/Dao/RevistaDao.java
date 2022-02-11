package Dao;

import Entities.Revista;
import Interfaces.Interfaz;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

import static Connection.Connection.*;

public class RevistaDao implements Interfaz<Revista, Long> {
    @Override
    public void create(Revista revista) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(revista);
        tx.commit();
        disconection();
    }

    @Override
    public Revista findById(Long s) {
        conection();
        Revista revista = em.find(Revista.class, s);
        disconection();
        return revista;    }

    @Override
    public List<Revista> read() {
        conection();
        TypedQuery<Revista> consulta=em.createQuery("Select l from Revista l", Revista.class);
        List<Revista> revistas = consulta.getResultList();
        disconection();
        return revistas;     }

    @Override
    public void delete(Revista revista) {
        conection();
       // Emp regado empregadoDelete = em.find(Empregado.class, empregado.getDni());
      //  if (revista != null ){
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(revista);
            tx.commit();
      //  }else {
      //      System.out.println("Este empregado non existe");
     //   }
        disconection();
    }
}
