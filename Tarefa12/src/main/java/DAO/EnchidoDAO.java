package DAO;

import Entity.Enchido;
import Entity.Repostaxe;

import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.util.List;

import static Connection.Connection.*;

public class EnchidoDAO {
    public void create(Enchido enchido ) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(enchido);
        tx.commit();
        disconection();
    }

    public List<Enchido> read() {
        conection();
        TypedQuery<Enchido> consulta=em.createQuery("Select l from Enchido l", Enchido.class);
        List<Enchido> enchidos = consulta.getResultList();
        disconection();
        return enchidos;
    }

    public void delete(Enchido enchido) throws Exception {
        conection();
        try {
            em.getTransaction().begin();
            try {
                enchido = em.getReference(Enchido.class, "enchido.getId()");
            } catch (EntityNotFoundException enfe) {
                throw new Exception("O enchido co id " + enchido.getId() + " xa non existe.", enfe);
            }
            em.remove(enchido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
