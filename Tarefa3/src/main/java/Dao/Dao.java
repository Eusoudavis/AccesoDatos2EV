package Dao;

import Entity.Empregado;
import Interfaz.Interfaz;

import javax.persistence.*;
import java.util.List;

public class Dao implements Interfaz<Empregado, String> {

    EntityManagerFactory emf;
    EntityManager em;

    public void conection() {
        emf = Persistence.createEntityManagerFactory("empregado");
        em = emf.createEntityManager();
    }

    public void disconection(){
        em.close();
        emf.close();
    }

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
            conection();
            Empregado empregado = em.find(Empregado.class, s);
            disconection();
            return empregado;
        }

    @Override
    public List<Empregado> read() {
        conection();
        TypedQuery<Empregado> consulta=em.createQuery("Select l from Empregado l", Empregado.class);
        List<Empregado> empregados = consulta.getResultList();
        disconection();
        return empregados;    }

    @Override
    public void update(Empregado empregado) {
        conection();
        Empregado empr = em.find(Empregado.class, empregado.getDni());
        if (empr !=null){
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            empr.setNombre(empregado.getNombre());
            empr.setSueldo(empregado.getSueldo());
            empr.setOficina(empregado.getOficina());
            empr.setPosto(empregado.getPosto());
            tx.commit();
        }else {
            System.out.println("Este empregado non existe");
        }
        disconection();
    }

    @Override
    public void delete(Empregado empregado) {
        conection();
        Empregado empregadoDelete = em.find(Empregado.class, empregado.getDni());
        if (empregadoDelete != null ){
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(empregadoDelete);
            tx.commit();
        }else {
            System.out.println("Este empregado non existe");
        }
        disconection();
    }
    }

