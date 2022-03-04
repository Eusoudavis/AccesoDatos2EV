package Dao;

import Entities.Team;

import javax.persistence.EntityTransaction;

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

    public Team findById(Long id) {
        conection();
        Team team = em.find(Team.class, id);
        disconection();
        return team;
    }
}
