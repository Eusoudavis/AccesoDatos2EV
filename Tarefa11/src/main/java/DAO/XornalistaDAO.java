package DAO;

import Entity.Xornalista;

import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.util.List;

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

    public Xornalista findById(String dni) {
        conection();
        Xornalista xornalista = em.find(Xornalista.class, dni);
        disconection();
        return xornalista;    }

    public List<Xornalista> read() {
        conection();
        TypedQuery<Xornalista> consulta=em.createQuery("Select l from Xornalista l", Xornalista.class);
        List<Xornalista> xornalistas = consulta.getResultList();
        disconection();
        return xornalistas;     }

    public void delete(Xornalista xornalista) throws Exception {
        conection();
        try {
            em.getTransaction().begin();
            try {
                xornalista = em.getReference(Xornalista.class, xornalista.getDni());
            } catch (EntityNotFoundException enfe) {
                throw new Exception("O xornalista co dni " + xornalista.getDni() + " xa non existe.", enfe);
            }
            em.remove(xornalista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
