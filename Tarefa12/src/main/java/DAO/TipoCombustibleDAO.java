package DAO;

import Entity.Repostaxe;
import Entity.TipoCombustible;

import javax.persistence.EntityTransaction;

import static Connection.Connection.*;

public class TipoCombustibleDAO {
    public void create(TipoCombustible tipoCombustible ) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(tipoCombustible);
        tx.commit();
        disconection();
    }
}
