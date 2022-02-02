package DAO;

import Connection.Connection;
import entity.Empregado;
import interfaz.interfaz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class DaoEmpregado extends Connection implements interfaz<Empregado, String> {
/*    protected EntityManagerFactory emf;
    protected EntityManager em;

    public void conection() {
        emf = Persistence.createEntityManagerFactory("empregado");
        em = emf.createEntityManager();
    }

    public void disconection(){
        em.close();
        emf.close();
    }*/
    @Override
    public void create(Empregado empregado) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(empregado);
        tx.commit();
        disconection();
    }

    @Override
    public Empregado findById(String s) {
        return null;
    }

    @Override
    public List<Empregado> read() {
        return null;
    }

    @Override
    public void update(Empregado empregado) {

    }

    @Override
    public void delete(Empregado empregado) {

    }
}
