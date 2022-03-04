package Dao;

import Entities.Player;

import javax.persistence.EntityTransaction;

import static Connection.Connection.*;

public class PlayerDao {
    public void create(Player player) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(player);
        tx.commit();
        disconection();
    }

    public Player findById(Long id) {
        conection();
        Player player = em.find(Player.class, id);
        disconection();
        return player;
    }
}
