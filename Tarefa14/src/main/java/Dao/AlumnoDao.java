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

    public void delete(Alumno alumno) {
        conection();
        Alumno  alumnoDelete = em.find(Alumno.class, alumno.getIdAlumno());
        if (alumnoDelete != null ){
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(alumnoDelete);
            tx.commit();
        }else {
            System.out.println("Este empregado non existe");
        }
        disconection();
    }

}
