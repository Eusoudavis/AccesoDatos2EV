package DAO;

import Entity.Factura;
import Entity.Repostaxe;

import javax.persistence.EntityTransaction;

import static Connection.Connection.*;

public class FacturaDAO {
    public void create(Factura factura) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(factura);
        tx.commit();
        disconection();
    }
}
