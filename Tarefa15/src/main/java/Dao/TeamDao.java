package Dao;

import Entities.Team;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.util.List;

import static Connection.Connection.*;

public class TeamDao {
    public void create(Team team) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(team);
        tx.commit();
        disconection();
    }

    public Team findById(String id) {
        conection();
        Team team = em.find(Team.class, id);
        disconection();
        return team;
    }

    public List<Team> read() {
        conection();
        TypedQuery<Team> consulta = em.createQuery("Select l from Team l ", Team.class);
        List<Team> teams = consulta.getResultList();
        disconection();
        return teams;
    }

    public void delete(Team team) {
        conection();
        Team  teamDelete = em.find(Team.class, team.getNie());
        if (teamDelete != null ){
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(teamDelete);
            tx.commit();
        }else {
            System.out.println("Esta equipa non existe");
        }
        disconection();
    }

}
