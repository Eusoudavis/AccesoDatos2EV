package Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
    protected EntityManagerFactory emf;
    protected EntityManager em;

    public void conection() {
        emf = Persistence.createEntityManagerFactory("empregado");
        em = emf.createEntityManager();
    }

    public void disconection(){
        em.close();
        emf.close();
    }
}
