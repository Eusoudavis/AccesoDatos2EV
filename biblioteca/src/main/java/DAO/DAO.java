package DAO;

import entity.Libro;
import interfaz.interfaz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class DAO implements interfaz<Libro, String> {
    EntityManagerFactory emf;
    EntityManager em;

    private void conection() {
        emf = Persistence.createEntityManagerFactory("biblioteca");
        em = emf.createEntityManager();
    }

	private void disconection(){
		em.close();
		emf.close();
	}

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
        return null;
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
	
	
	/*
	public void create() {
		System.out.println("Introducir os datos do libro");
		Libro libro = new Libro();
		System.out.println("Introducir isbn");
		libro.setIsbn(sc.nextLine());
		System.out.println("Introducir titulo");
		libro.setTitulo(sc.nextLine());
		System.out.println("Introducir autor");
		libro.setAutor(sc.nextLine());
		System.out.println("Introducir data");
		String fechaComoTexto = sc.nextLine();
		SimpleDateFormat sdf= new SimpleDateFormat("d/M/yyyy");
		Date fecha =null;
		fecha = (Date) sdf.parse(fechaComoTexto);
		libro.setFecha(fecha);
		System.out.println("Introducir prezo");
		libro.setPrecio(sc.nextInt());
		
		em.getTransaction().begin();
		em.persist(libro);
		em.getTransaction().commit();
	}
	
	public void update() {
	}
	}*/
}
