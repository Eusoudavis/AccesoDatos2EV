package Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
    protected static EntityManagerFactory emf;
    public static EntityManager em;

    public static void conection() {
        emf = Persistence.createEntityManagerFactory("taxis");
        em = emf.createEntityManager();
    }

    public static void disconection(){
        em.close();
        emf.close();
    }
}
