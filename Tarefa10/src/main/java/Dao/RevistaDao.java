package Dao;

import Entities.Manual;
import Entities.Revista;
import Interfaces.Interfaz;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
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
    public void delete(Revista revista) throws Exception {
        conection();
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            try {
                revista = em.getReference(Revista.class, revista.getIsbn());
               // revista.getIsbn();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("O manual con id " + revista.getIsbn() + " xa non existe.", enfe);
            }
            em.remove(revista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void outroDelete(Long id) throws Exception {
        conection();
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Revista revista;
            try {
                revista = em.getReference(Revista.class, id);
                revista.getIsbn();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("O manual con id " + id + " xa non existe.", enfe);
            }
            em.remove(revista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private EntityManager getEntityManager() {
        return  em;
    }
}
