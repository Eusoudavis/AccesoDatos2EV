package DAO;

import Entity.Enchido;
import lombok.extern.log4j.Log4j2;

import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.util.List;

import static Connection.Connection.*;

@Log4j2
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

    public void delete() throws Exception {
        conection();
        try {
            em.getTransaction().begin();
            TypedQuery<Enchido> consulta=em.createQuery("Select l from Enchido l", Enchido.class);
            Enchido enchidos[] = consulta.getResultList().toArray(new Enchido[0]);
            Enchido enchido = enchidos[enchidos.length-1];
            em.remove(enchido);
            em.getTransaction().commit();
            log.info("-----------------------------ENCHIDO " + enchido.getId() + " BORRADO CORRECTAMENTE--------------------");
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
