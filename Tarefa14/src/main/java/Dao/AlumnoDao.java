package Dao;

import Entities.Alumno;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.util.List;

import static Connection.Connection.*;

public class AlumnoDao {
    public void create(Alumno alumno) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(alumno);
        tx.commit();
        disconection();
    }

    public Alumno findById(String id) {
        conection();
        Alumno alumno = em.find(Alumno.class, id);
        disconection();
        return alumno;
    }

    public List<Alumno> read() {
        conection();
        TypedQuery<Alumno> consulta = em.createQuery("Select l from Alumno l ", Alumno.class);
        List<Alumno> alumnos = consulta.getResultList();
        disconection();
        return alumnos;
    }

    public List<Alumno> readAlumnoSinPC() {
        conection();
        TypedQuery<Alumno> consulta = em.createQuery("Select l from Alumno l where Ordenador.idPC = null ", Alumno.class);
        List<Alumno> alumnos = consulta.getResultList();
        disconection();
        return alumnos;
    }
}
