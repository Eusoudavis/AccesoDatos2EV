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

    public void updateComercial() {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query consulta = em.createQuery("Update Empregado l Set l.sueldo = 1500 WHERE l.puesto='comercial'");
        consulta.executeUpdate();
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

    public List<Empregado> findByOffice() {
        conection();
        TypedQuery<Empregado> consulta=em.createQuery("Select l from Empregado l where l.oficina is not (11) order by l.sueldo desc", Empregado.class);
        List<Empregado> empregados = consulta.getResultList();
        disconection();
        return empregados;    }

    public List<Object[]> salaryStatsByOffice() {
        conection();
        TypedQuery<Object[]> consulta=em.createQuery("Select MAX(l.sueldo), MIN(l.sueldo), AVG(l.sueldo), l.oficina from Empregado l group by l.oficina", Object[].class);
        List<Object[]> empregados = consulta.getResultList();
        disconection();
        return empregados;    }



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
            empr.setPuesto(empregado.getPuesto());
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

    public void deleteNegativeSalary() {
        conection();
        TypedQuery<Empregado> consultaFind = em.createQuery("Select l from Empregado l where l.sueldo < 0", Empregado.class);
        List<Empregado> empregados = consultaFind.getResultList();
        for (Empregado empNe: empregados
             ) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(empNe);
            tx.commit();
        }
        disconection();
    }

    public List<Integer> readAllOffice() {
        conection();
        TypedQuery<Integer> consulta=em.createQuery("Select l.oficina from Empregado l ", Integer.class);
        List<Integer> empregados = consulta.getResultList();
        disconection();
        return empregados;    }


    public List<Empregado> findEmployeeByOffice(int num) {
        conection();
        TypedQuery<Empregado> consulta=em.createQuery("Select l from Empregado l where l.oficina=?1 ", Empregado.class);
        consulta.setParameter(1, num);
        List<Empregado> empregados = consulta.getResultList();
        disconection();
        return empregados;    }

    }

