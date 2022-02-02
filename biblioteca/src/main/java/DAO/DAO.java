package DAO;

import Connection.Connection;
import entity.Libro;
import interfaz.interfaz;

import javax.persistence.*;
import java.util.List;

public class DAO extends Connection implements interfaz<Libro, String> {


    @Override
    public void create(Libro libro) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(libro);
        tx.commit();
		disconection();
    }

    @Override
    public Libro findById( String k) {
        conection();
        Libro libro = em.find(Libro.class, k);
        disconection();
        return libro;
    }

    @Override
    public List<Libro> read() {
        conection();
        TypedQuery<Libro> consulta=em.createQuery("Select l from Libro l", Libro.class);
        List<Libro> libros = consulta.getResultList();
        disconection();
        return libros;
    }

    @Override
    public void update(Libro libro) {
        conection();
        Libro lib = em.find(Libro.class, libro.getIsbn());
        if (lib !=null){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        lib.setTitulo(libro.getTitulo());
        lib.setAutor(libro.getAutor());
        lib.setPrecio(libro.getPrecio());
        tx.commit();
        }else {
            System.out.println("Este libro non existe");
        }
        disconection();
    }

    @Override
    public void delete(Libro libro) {
		conection();
        Libro libroDelete = em.find(Libro.class, libro.getIsbn());
        if (libroDelete != null ){
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(libroDelete);
		tx.commit();
        }else {
            System.out.println("Este libro non existe");
        }
		disconection();
    }
}
