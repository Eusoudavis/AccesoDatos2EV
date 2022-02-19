package DAO;

import Entity.Artigos;
import Entity.Xornalista;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.util.List;

import static Connection.Connection.*;

public class ArtigoDAO {
    public void create(Artigos artigos) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(artigos);
        tx.commit();
        disconection();
    }

    public List<Artigos> readArtigo(String dni) {
        conection();
        TypedQuery<Artigos> consulta=em.createQuery("Select l from Artigos l where l.xornalista.dni=:dni", Artigos.class);
        consulta.setParameter("dni", dni);
        List<Artigos> artigos = consulta.getResultList();
        disconection();
        return artigos;
    }

    public List<Artigos> readArtigoByYear(int ano) {
        conection();
        TypedQuery<Artigos> consulta=em.createQuery("Select l from Artigos l where l.year=?1", Artigos.class);
        consulta.setParameter(1, ano);
        List<Artigos> artigos = consulta.getResultList();
        disconection();
        return artigos;
    }
}
