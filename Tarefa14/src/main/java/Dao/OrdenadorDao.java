package Dao;

import Entities.Alumno;
import Entities.Ordenador;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import static Connection.Connection.*;

public class OrdenadorDao {
    public void create(Ordenador ordenador) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(ordenador);
        tx.commit();
        disconection();
    }

    public List<Ordenador> readSinAlumno() {
        conection();
        TypedQuery<Ordenador> consulta = em.createQuery("Select l from Ordenador l where l.alumno is null ", Ordenador.class);
        List<Ordenador> ordenadors = consulta.getResultList();
        disconection();
        return ordenadors;
    }

    public Ordenador findById(String id) {
        conection();
        Ordenador ordenador = em.find(Ordenador.class, id);
        disconection();
        return ordenador;
    }

    public void updatePC(Ordenador ordenador) {
       // Ordenador ordenadorDB = findById(ordenador.getIdPC());
        conection();
        EntityTransaction tx = em.getTransaction();
        Ordenador ordenadorDB = em.find(Ordenador.class, ordenador.getIdPC());
        tx.begin();
        if (ordenadorDB.getIdPC().equals(ordenador.getIdPC())){
            ordenadorDB.setAlumno(ordenador.getAlumno());
        }
        tx.commit();
        disconection();
    }

    public void updatePCNoDelete(Ordenador ordenador) {
        // Ordenador ordenadorDB = findById(ordenador.getIdPC());
        conection();
        EntityTransaction tx = em.getTransaction();
        Ordenador ordenadorDB = em.find(Ordenador.class, ordenador.getIdPC());
        tx.begin();
        if (ordenadorDB.getIdPC().equals(ordenador.getIdPC())){
            ordenadorDB.setAlumno(ordenador.getAlumno());
        }
        tx.commit();
        disconection();
    }


}
